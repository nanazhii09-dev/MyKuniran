package com.mykuniran.data.repository

import com.mykuniran.core.common.ExceptionMapper
import com.mykuniran.core.common.Resource
import com.mykuniran.core.database.ProfileDao
import com.mykuniran.core.database.ProfileEntity
import com.mykuniran.core.model.UserProfile
import com.mykuniran.core.model.UserRole
import com.mykuniran.core.network.SessionManager
import com.mykuniran.core.network.SupabaseApiService
import com.mykuniran.core.network.SupabaseConfig
import com.mykuniran.core.network.toDomain
import com.mykuniran.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.UUID

class AuthRepositoryImpl(
    private val apiService: SupabaseApiService,
    private val profileDao: ProfileDao,
    private val sessionManager: SessionManager
) : AuthRepository {

    override fun getCurrentUserFlow(): Flow<UserProfile?> {
        val uid = sessionManager.getUserId() ?: ""
        return profileDao.getProfileFlow(uid).map { it?.toDomain() }
    }

    override suspend fun getCurrentUser(): UserProfile? = withContext(Dispatchers.IO) {
        val uid = sessionManager.getUserId() ?: return@withContext null
        profileDao.getProfile(uid)?.toDomain()
    }

    override suspend fun signInWithGoogle(
        idToken: String,
        email: String,
        name: String
    ): Resource<UserProfile> = withContext(Dispatchers.IO) {
        try {
            require(idToken.isNotBlank()) { "AUTH_NO_ID_TOKEN" }

            val authResult = apiService.signInWithIdToken(
                mapOf("provider" to "google", "id_token" to idToken)
            )
            if (!authResult.isSuccessful) {
                val errBody = authResult.errorBody()?.string().orEmpty()
                android.util.Log.e("MyKuniranAuth", "Supabase id_token gagal HTTP ${authResult.code()}: $errBody")
                throw Exception("AUTH_FAILED HTTP ${authResult.code()}: $errBody")
            }
            val authData = authResult.body()
                ?: throw Exception("AUTH_FAILED respon kosong")
            val token = authData.accessToken
            val userId = authData.user?.id
                ?: throw Exception("AUTH_FAILED tanpa user id")

            // Save session credentials
            sessionManager.saveSession(
                accessToken = token,
                userId = userId
            )

            // Try fetching existing profile from Supabase
            val remoteProfiles = runCatching {
                apiService.getProfile("eq.$userId")
            }.getOrNull()

            val profile: UserProfile = if (!remoteProfiles.isNullOrEmpty()) {
                val p = remoteProfiles.first().toDomain()
                sessionManager.updateRtId(p.rtId, p.role.name)
                p
            } else {
                val newProfile = UserProfile(
                    id = userId,
                    rtId = null,
                    fullName = name.ifBlank { "Warga Baru" },
                    email = email.ifBlank { null },
                    avatarPath = null,
                    houseInfo = null,
                    phoneNumber = null,
                    role = UserRole.WARGA,
                    isActive = true,
                    createdAt = System.currentTimeMillis().toString(),
                    updatedAt = System.currentTimeMillis().toString()
                )
                newProfile
            }

            profileDao.insertProfile(ProfileEntity.fromDomain(profile))
            Resource.Success(profile)
        } catch (e: Exception) {
            Resource.Error(ExceptionMapper.map(e))
        }
    }

    override suspend fun updateProfile(
        fullName: String,
        phoneNumber: String?,
        houseInfo: String?
    ): Resource<Unit> = withContext(Dispatchers.IO) {
        val uid = sessionManager.getUserId() ?: return@withContext Resource.Error(com.mykuniran.core.common.AppError.SessionExpired)
        try {
            val body = mapOf(
                "full_name" to fullName,
                "phone_number" to phoneNumber,
                "house_info" to houseInfo
            )
            apiService.updateProfile("eq.$uid", body)

            val current = profileDao.getProfile(uid)
            if (current != null) {
                profileDao.insertProfile(
                    current.copy(
                        fullName = fullName,
                        phoneNumber = phoneNumber,
                        houseInfo = houseInfo
                    )
                )
            }
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(ExceptionMapper.map(e))
        }
    }

    override suspend fun signOut(): Resource<Unit> = withContext(Dispatchers.IO) {
        try {
            sessionManager.clearSession()
            profileDao.clearAll()
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(ExceptionMapper.map(e))
        }
    }
}
