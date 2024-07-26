package com.stanroy.jetdex.domain.usecases

import com.stanroy.jetdex.data.remote.response.list.MonListResponse
import com.stanroy.jetdex.domain.repo.MonListRepository
import javax.inject.Inject

class GetMonListUseCase @Inject constructor(private val monListRepository: MonListRepository) {

    suspend operator fun invoke(limit: Int, offset: Int): MonListResponse {
        return monListRepository.getMonList(limit, offset)
    }
}