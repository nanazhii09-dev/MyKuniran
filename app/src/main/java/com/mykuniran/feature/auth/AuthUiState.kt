package com.mykuniran.feature.auth

import com.mykuniran.core.common.AppError
import com.mykuniran.core.model.UserProfile

data class AuthUiState(
    val currentUser: UserProfile? = null,
    val isLoading: Boolean = false,
    val error: AppError? = null,
    val joinStatus: String? = null,
    val previewLabel: String? = null,
    val usernameAvailable: String? = null
)
