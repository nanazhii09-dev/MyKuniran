package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.core.model.RsvpStatus
import com.mykuniran.domain.repository.PostRepository

class SubmitRsvpUseCase(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(
        postId: String,
        userId: String,
        rtId: String,
        status: RsvpStatus
    ): Resource<Unit> {
        return postRepository.submitRsvp(
            postId = postId,
            userId = userId,
            rtId = rtId,
            status = status
        )
    }
}
