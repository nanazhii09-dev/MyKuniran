package com.mykuniran.domain.usecase

import com.mykuniran.core.model.FinanceTransaction
import com.mykuniran.domain.repository.FinanceRepository
import kotlinx.coroutines.flow.Flow

class GetAllRtTransactionsUseCase(
    private val financeRepository: FinanceRepository
) {
    operator fun invoke(rtId: String): Flow<List<FinanceTransaction>> {
        return financeRepository.getAllRtTransactionsFlow(rtId)
    }
}
