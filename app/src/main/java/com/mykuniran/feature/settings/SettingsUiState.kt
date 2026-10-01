package com.mykuniran.feature.settings

import com.mykuniran.core.common.AppError
import com.mykuniran.core.model.RtGroup
import com.mykuniran.core.model.UserProfile

data class SettingsUiState(
    val currentUser: UserProfile? = null,
    val rtGroup: RtGroup? = null,
    val isLoading: Boolean = false,
    val error: AppError? = null
)
