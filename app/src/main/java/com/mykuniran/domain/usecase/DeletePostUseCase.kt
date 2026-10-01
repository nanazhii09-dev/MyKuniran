package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.PostRepository

class DeletePostUseCase(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(postId: String): Resource<Unit> {
        return postRepository.deletePost(postId)
    }
}
