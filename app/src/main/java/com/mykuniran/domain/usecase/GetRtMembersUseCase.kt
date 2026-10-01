package com.mykuniran.domain.usecase

import com.mykuniran.core.model.RtMember
import com.mykuniran.domain.repository.MemberRepository
import kotlinx.coroutines.flow.Flow

class GetRtMembersUseCase(
    private val memberRepository: MemberRepository
) {
    operator fun invoke(): Flow<List<RtMember>> {
        return memberRepository.getMembersFlow()
    }
}
