package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.FinanceRepository

class CreateFinanceCategoryUseCase(
    private val financeRepository: FinanceRepository
) {
    suspend operator fun invoke(rtId: String, name: String, description: String?): Resource<Unit> {
        return financeRepository.createCategory(rtId, name, description)
    }
}
