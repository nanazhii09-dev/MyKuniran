package com.mykuniran.domain.repository

import com.mykuniran.core.common.Resource
import com.mykuniran.core.model.Post
import com.mykuniran.core.model.PostRsvp
import com.mykuniran.core.model.PostType
import com.mykuniran.core.model.RsvpStatus
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getPostsFlow(rtId: String): Flow<List<Post>>
    suspend fun syncPosts(rtId: String): Resource<Unit>
    suspend fun createPost(
        rtId: String,
        authorId: String,
        title: String,
        content: String,
        type: PostType,
        eventDate: String? = null,
        eventLocation: String? = null
    ): Resource<Unit>
    suspend fun pinPost(postId: String): Resource<Unit>
    suspend fun unpinPost(postId: String): Resource<Unit>
    suspend fun deletePost(postId: String): Resource<Unit>
    suspend fun submitRsvp(
        postId: String,
        userId: String,
        rtId: String,
        status: RsvpStatus
    ): Resource<Unit>
    fun getRsvpsFlow(rtId: String): Flow<List<PostRsvp>>
}
