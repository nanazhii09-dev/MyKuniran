package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.FinanceRepository

class UpdateFinanceCategoryUseCase(
    private val financeRepository: FinanceRepository
) {
    suspend operator fun invoke(
        categoryId: String,
        name: String,
        description: String?,
        isArchived: Boolean = false
    ): Resource<Unit> {
        return financeRepository.updateCategory(categoryId, name, description, isArchived)
    }
}
