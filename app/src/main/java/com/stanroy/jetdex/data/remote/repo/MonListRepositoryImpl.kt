package com.stanroy.jetdex.data.remote.repo

import com.stanroy.jetdex.data.remote.api.PokeApi
import com.stanroy.jetdex.data.remote.response.list.MonListResponse
import com.stanroy.jetdex.domain.repo.MonListRepository
import javax.inject.Inject

class MonListRepositoryImpl @Inject constructor(private val pokeApi: PokeApi) :
    MonListRepository {

    override suspend fun getMonList(limit: Int, offset: Int): MonListResponse {
        return pokeApi.getMonList(limit, offset)
    }


}