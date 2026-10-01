package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.AuthRepository

class UpdateProfileUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(fullName: String, phoneNumber: String?, houseInfo: String?): Resource<Unit> {
        return authRepository.updateProfile(fullName, phoneNumber, houseInfo)
    }
}
