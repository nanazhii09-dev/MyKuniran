package com.mykuniran.feature.finance

import com.mykuniran.core.common.AppError
import com.mykuniran.core.model.FinanceRecord
import com.mykuniran.core.model.MonthlyTrendDataPoint
import com.mykuniran.core.model.TransactionType

data class FinanceRecordUiState(
    val isLoading: Boolean = false,
    val records: List<FinanceRecord> = emptyList(),
    val filteredRecords: List<FinanceRecord> = emptyList(),
    val monthlyTrends: List<MonthlyTrendDataPoint> = emptyList(),
    val categorizedRecords: Map<String, List<FinanceRecord>> = emptyMap(),
    val filterType: TransactionType? = null,
    val searchQuery: String = "",
    val totalIncome: Long = 0L,
    val totalExpense: Long = 0L,
    val netBalance: Long = 0L,
    val error: AppError? = null
)
