package com.mykuniran.feature.forum

import com.mykuniran.core.common.AppError
import com.mykuniran.core.model.Post

enum class ForumFilter {
    ALL,
    QUESTION,
    SUGGESTION
}

data class ForumThreadUiState(
    val isLoading: Boolean = false,
    val threads: List<Post> = emptyList(),
    val filteredThreads: List<Post> = emptyList(),
    val selectedFilter: ForumFilter = ForumFilter.ALL,
    val showCreateDialog: Boolean = false,
    val successMessage: String? = null,
    val error: AppError? = null
)
