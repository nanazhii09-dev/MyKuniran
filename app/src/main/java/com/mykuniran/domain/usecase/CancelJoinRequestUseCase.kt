package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.RtRepository

class CancelJoinRequestUseCase(
    private val rtRepository: RtRepository
) {
    suspend operator fun invoke(): Resource<Unit> {
        return rtRepository.cancelJoinRequest()
    }
}
