package com.mykuniran.domain.usecase

import com.mykuniran.core.common.Resource
import com.mykuniran.domain.repository.RtRepository

class PreviewRtUseCase(
    private val rtRepository: RtRepository
) {
    suspend operator fun invoke(inviteUsername: String): Resource<String?> {
        return rtRepository.previewRt(inviteUsername)
    }
}
