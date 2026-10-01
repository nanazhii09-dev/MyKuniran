package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.PostRepository

class SyncFeedUseCase(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(rtId: String): Resource<Unit> {
        return postRepository.syncPosts(rtId)
    }
}
