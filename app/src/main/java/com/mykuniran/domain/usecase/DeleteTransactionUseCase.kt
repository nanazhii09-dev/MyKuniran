package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.FinanceRepository

class DeleteTransactionUseCase(
    private val financeRepository: FinanceRepository
) {
    suspend operator fun invoke(id: String): Resource<Unit> {
        return financeRepository.deleteTransaction(id)
    }
}
