package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.core.model.UserProfile
import com.mykuniran.domain.repository.AuthRepository

class SignInWithGoogleUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(idToken: String, email: String, name: String): Resource<UserProfile> {
        return authRepository.signInWithGoogle(idToken, email, name)
    }
}
