package com.mykuniran.feature.home

import com.mykuniran.core.common.AppError
import com.mykuniran.core.model.Post
import com.mykuniran.core.model.RtGroup
import com.mykuniran.core.model.UserProfile

data class HomeUiState(
    val posts: List<Post> = emptyList(),
    val currentUser: UserProfile? = null,
    val rtGroup: RtGroup? = null,
    val selectedFilter: String = "ALL", // "ALL", "PENGUMUMAN", "AGENDA", "FINANCE_REPORT"
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val error: AppError? = null
)
