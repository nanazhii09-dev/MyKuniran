package com.mykuniran.feature.agenda

import com.mykuniran.core.common.AppError
import com.mykuniran.core.model.AgendaRsvpSummary
import com.mykuniran.core.model.Post

data class CalendarRsvpUiState(
    val isLoading: Boolean = false,
    val selectedDate: String? = null, // e.g. "2026-10-01" or null for all
    val agendas: List<Post> = emptyList(),
    val filteredAgendas: List<Post> = emptyList(),
    val rsvpSummaries: Map<String, AgendaRsvpSummary> = emptyMap(),
    val successMessage: String? = null,
    val error: AppError? = null
)
