package com.mykuniran.feature.attendance

import com.mykuniran.core.common.AppError
import com.mykuniran.core.model.WargaActivityLog

data class AttendanceUiState(
    val isLoading: Boolean = false,
    val history: List<WargaActivityLog> = emptyList(),
    val lastScannedEvent: String? = null,
    val successMessage: String? = null,
    val error: AppError? = null,
    val showManualDialog: Boolean = false
)
