package com.mykuniran.domain.usecase

import com.mykuniran.core.model.PostRsvp
import com.mykuniran.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class GetAgendaRsvpsUseCase(
    private val postRepository: PostRepository
) {
    operator fun invoke(rtId: String): Flow<List<PostRsvp>> {
        return postRepository.getRsvpsFlow(rtId)
    }
}
