package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.MemberRepository

class AssignBendaharaUseCase(
    private val memberRepository: MemberRepository
) {
    suspend operator fun invoke(categoryId: String, profileId: String?): Resource<Unit> {
        return memberRepository.assignBendahara(categoryId, profileId)
    }
}
