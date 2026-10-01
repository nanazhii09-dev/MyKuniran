package com.mykuniran.domain.repository

import com.mykuniran.core.common.Resource
import com.mykuniran.core.model.FinanceRecord
import kotlinx.coroutines.flow.Flow

interface FinanceRecordRepository {
    fun getFinanceRecords(rtId: String): Flow<Resource<List<FinanceRecord>>>
    suspend fun createFinanceRecord(record: FinanceRecord): Resource<Unit>
    suspend fun updateFinanceRecord(id: String, updates: Map<String, Any?>): Resource<Unit>
    suspend fun deleteFinanceRecord(id: String): Resource<Unit>
}
