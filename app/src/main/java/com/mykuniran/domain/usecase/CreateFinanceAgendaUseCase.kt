package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.FinanceRepository

class CreateFinanceAgendaUseCase(
    private val financeRepository: FinanceRepository
) {
    suspend operator fun invoke(categoryId: String, title: String, eventDate: String, location: String): Resource<String> {
        return financeRepository.createFinanceAgenda(categoryId, title, eventDate, location)
    }
}
