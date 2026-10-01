package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.RtRepository

class CheckUsernameAvailableUseCase(
    private val rtRepository: RtRepository
) {
    suspend operator fun invoke(username: String): Resource<String> {
        return rtRepository.checkUsernameAvailable(username)
    }
}
