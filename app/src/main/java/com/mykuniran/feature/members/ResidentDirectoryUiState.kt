package com.mykuniran.feature.members

import com.mykuniran.core.common.AppError
import com.mykuniran.core.model.Warga

data class ResidentDirectoryUiState(
    val isLoading: Boolean = false,
    val residents: List<Warga> = emptyList(),
    val filteredResidents: List<Warga> = emptyList(),
    val searchQuery: String = "",
    val availableBlocks: List<String> = emptyList(),
    val selectedBlock: String? = null,
    val error: AppError? = null
)
