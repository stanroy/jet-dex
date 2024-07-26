package com.stanroy.jetdex.domain.repo

import com.stanroy.jetdex.data.remote.response.list.MonListResponse

interface MonListRepository {

    suspend fun getMonList(limit: Int, offset: Int): MonListResponse

}