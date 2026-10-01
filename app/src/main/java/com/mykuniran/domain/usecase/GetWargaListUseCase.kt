package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.core.model.Warga
import com.mykuniran.domain.repository.WargaRepository
import kotlinx.coroutines.flow.Flow

class GetWargaListUseCase(
    private val wargaRepository: WargaRepository
) {
    operator fun invoke(rtId: String): Flow<Resource<List<Warga>>> {
        return wargaRepository.getWargaList(rtId)
    }
}
