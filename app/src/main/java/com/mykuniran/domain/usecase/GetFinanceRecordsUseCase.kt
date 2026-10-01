package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.core.model.FinanceRecord
import com.mykuniran.domain.repository.FinanceRecordRepository
import kotlinx.coroutines.flow.Flow

class GetFinanceRecordsUseCase(
    private val financeRecordRepository: FinanceRecordRepository
) {
    operator fun invoke(rtId: String): Flow<Resource<List<FinanceRecord>>> {
        return financeRecordRepository.getFinanceRecords(rtId)
    }
}
