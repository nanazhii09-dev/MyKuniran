package com.mykuniran.feature.members

import com.mykuniran.core.common.AppError
import com.mykuniran.core.model.JoinRequest
import com.mykuniran.core.model.RtMember
import com.mykuniran.core.model.UserProfile

data class MembersUiState(
    val members: List<RtMember> = emptyList(),
    val pendingRequests: List<JoinRequest> = emptyList(),
    val currentUser: UserProfile? = null,
    val searchQuery: String = "",
    val isLoading: Boolean = false,
    val error: AppError? = null
)
