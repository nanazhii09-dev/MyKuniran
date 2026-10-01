package com.mykuniran.domain.usecase

import com.mykuniran.core.model.FinanceCategory
import com.mykuniran.domain.repository.FinanceRepository
import kotlinx.coroutines.flow.Flow

class GetFinanceCategoriesUseCase(
    private val financeRepository: FinanceRepository
) {
    operator fun invoke(rtId: String): Flow<List<FinanceCategory>> {
        return financeRepository.getCategoriesFlow(rtId)
    }
}
