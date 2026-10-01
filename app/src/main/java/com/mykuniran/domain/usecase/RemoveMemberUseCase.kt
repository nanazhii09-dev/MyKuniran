package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.MemberRepository

class RemoveMemberUseCase(
    private val memberRepository: MemberRepository
) {
    suspend operator fun invoke(profileId: String): Resource<Unit> {
        return memberRepository.removeMember(profileId)
    }
}
