package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.RtRepository

class SetAutoApproveUseCase(
    private val rtRepository: RtRepository
) {
    suspend operator fun invoke(enabled: Boolean): Resource<Unit> {
        return rtRepository.setAutoApprove(enabled)
    }
}
