package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.MemberRepository

class SyncMembersUseCase(
    private val memberRepository: MemberRepository
) {
    suspend operator fun invoke(): Resource<Unit> {
        return memberRepository.syncMembers()
    }
}
