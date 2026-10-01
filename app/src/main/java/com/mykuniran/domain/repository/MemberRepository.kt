package com.mykuniran.domain.repository

import com.mykuniran.core.common.Resource
import com.mykuniran.core.model.RtMember
import kotlinx.coroutines.flow.Flow

interface MemberRepository {
    fun getMembersFlow(): Flow<List<RtMember>>
    suspend fun syncMembers(): Resource<Unit>
    suspend fun transferAdmin(newAdminId: String): Resource<Unit>
    suspend fun assignBendahara(categoryId: String, profileId: String?): Resource<Unit>
    suspend fun removeMember(profileId: String): Resource<Unit>
}
