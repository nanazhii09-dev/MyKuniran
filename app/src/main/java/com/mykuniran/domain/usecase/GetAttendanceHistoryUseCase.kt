package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.core.model.WargaActivityLog
import com.mykuniran.domain.repository.WargaRepository
import kotlinx.coroutines.flow.Flow

class GetAttendanceHistoryUseCase(
    private val wargaRepository: WargaRepository
) {
    operator fun invoke(wargaId: String): Flow<Resource<List<WargaActivityLog>>> {
        return wargaRepository.getAttendanceHistory(wargaId)
    }
}
