package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.core.model.JoinRequest
import com.mykuniran.domain.repository.RtRepository

class ListPendingJoinRequestsUseCase(
    private val rtRepository: RtRepository
) {
    suspend operator fun invoke(): Resource<List<JoinRequest>> {
        return rtRepository.listPendingRequests()
    }
}
