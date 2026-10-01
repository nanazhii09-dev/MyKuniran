package com.mykuniran.domain.repository

import com.mykuniran.core.common.Resource
import com.mykuniran.core.model.JoinRequest
import com.mykuniran.core.model.RtGroup
import kotlinx.coroutines.flow.Flow

interface RtRepository {
    fun getRtGroupFlow(rtId: String): Flow<RtGroup?>
    suspend fun fetchRtGroup(rtId: String): Resource<RtGroup>
    suspend fun createRt(
        name: String,
        rtNumber: String,
        rwNumber: String,
        desa: String,
        dukuh: String,
        lingkungan: String,
        inviteUsername: String
    ): Resource<String>
    suspend fun previewRt(inviteUsername: String): Resource<String?>
    suspend fun requestJoinRt(inviteUsername: String): Resource<String>
    suspend fun cancelJoinRequest(): Resource<Unit>
    suspend fun listPendingRequests(): Resource<List<JoinRequest>>
    suspend fun approveJoinRequest(requestId: String): Resource<Unit>
    suspend fun rejectJoinRequest(requestId: String): Resource<Unit>
    suspend fun setAutoApprove(enabled: Boolean): Resource<Unit>
    suspend fun checkUsernameAvailable(username: String): Resource<String>
    suspend fun setInviteUsername(username: String): Resource<Unit>
    suspend fun updateRtInfo(
        name: String,
        rtNumber: String,
        rwNumber: String,
        desa: String,
        dukuh: String,
        lingkungan: String
    ): Resource<Unit>
    suspend fun leaveRt(): Resource<Unit>
}
