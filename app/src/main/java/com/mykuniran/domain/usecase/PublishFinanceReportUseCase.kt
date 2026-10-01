package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.FinanceRepository

class PublishFinanceReportUseCase(
    private val financeRepository: FinanceRepository
) {
    suspend operator fun invoke(financeId: String, note: String? = null): Resource<String> {
        return financeRepository.publishFinanceReport(financeId, note)
    }
}
