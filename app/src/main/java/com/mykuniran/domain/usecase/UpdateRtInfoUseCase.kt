package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.RtRepository

class UpdateRtInfoUseCase(
    private val rtRepository: RtRepository
) {
    suspend operator fun invoke(
        name: String,
        rtNumber: String,
        rwNumber: String,
        desa: String,
        dukuh: String,
        lingkungan: String
    ): Resource<Unit> {
        return rtRepository.updateRtInfo(name, rtNumber, rwNumber, desa, dukuh, lingkungan)
    }
}
