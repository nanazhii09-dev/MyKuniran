package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.core.model.PostType
import com.mykuniran.domain.repository.PostRepository

class CreatePostUseCase(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(
        rtId: String,
        authorId: String,
        title: String,
        content: String,
        type: PostType,
        eventDate: String? = null,
        eventLocation: String? = null
    ): Resource<Unit> {
        return postRepository.createPost(
            rtId = rtId,
            authorId = authorId,
            title = title,
            content = content,
            type = type,
            eventDate = eventDate,
            eventLocation = eventLocation
        )
    }
}
