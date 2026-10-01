package com.mykuniran.domain.usecase

import com.mykuniran.core.model.FinanceTransaction
import com.mykuniran.domain.repository.FinanceRepository
import kotlinx.coroutines.flow.Flow

class GetTransactionsUseCase(
    private val financeRepository: FinanceRepository
) {
    operator fun invoke(categoryId: String): Flow<List<FinanceTransaction>> {
        return financeRepository.getTransactionsFlow(categoryId)
    }
}
