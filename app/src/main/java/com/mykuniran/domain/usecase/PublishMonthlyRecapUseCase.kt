package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.FinanceRepository

class PublishMonthlyRecapUseCase(
    private val financeRepository: FinanceRepository
) {
    suspend operator fun invoke(categoryId: String, monthDate: String): Resource<String> {
        return financeRepository.publishMonthlyRecap(categoryId, monthDate)
    }
}
