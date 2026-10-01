package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.RtRepository

class ApproveJoinRequestUseCase(
    private val rtRepository: RtRepository
) {
    suspend operator fun invoke(requestId: String): Resource<Unit> {
        return rtRepository.approveJoinRequest(requestId)
    }
}
