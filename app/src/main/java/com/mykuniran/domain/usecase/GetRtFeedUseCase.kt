package com.mykuniran.domain.usecase

import com.mykuniran.core.model.Post
import com.mykuniran.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class GetRtFeedUseCase(
    private val postRepository: PostRepository
) {
    operator fun invoke(rtId: String): Flow<List<Post>> {
        return postRepository.getPostsFlow(rtId)
    }
}
