package com.mykuniran.domain.repository

import com.mykuniran.core.common.Resource
import com.mykuniran.core.model.UserProfile
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun getCurrentUserFlow(): Flow<UserProfile?>
    suspend fun getCurrentUser(): UserProfile?
    suspend fun signInWithGoogle(idToken: String, email: String, name: String): Resource<UserProfile>
    suspend fun updateProfile(fullName: String, phoneNumber: String?, houseInfo: String?): Resource<Unit>
    suspend fun signOut(): Resource<Unit>
}
