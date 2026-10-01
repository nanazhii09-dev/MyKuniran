package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.MemberRepository

class TransferAdminUseCase(
    private val memberRepository: MemberRepository
) {
    suspend operator fun invoke(newAdminId: String): Resource<Unit> {
        return memberRepository.transferAdmin(newAdminId)
    }
}
