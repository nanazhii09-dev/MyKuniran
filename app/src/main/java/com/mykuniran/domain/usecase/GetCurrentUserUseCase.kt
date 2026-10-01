package com.mykuniran.domain.usecase

import com.mykuniran.core.model.UserProfile
import com.mykuniran.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow

class GetCurrentUserUseCase(
    private val authRepository: AuthRepository
) {
    operator fun invoke(): Flow<UserProfile?> = authRepository.getCurrentUserFlow()
}
