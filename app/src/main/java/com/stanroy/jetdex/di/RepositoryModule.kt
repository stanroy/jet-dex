package com.stanroy.jetdex.di

import com.stanroy.jetdex.data.remote.api.PokeApi
import com.stanroy.jetdex.data.remote.repo.MonListRepositoryImpl
import com.stanroy.jetdex.domain.repo.MonListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {


    @Provides
    @Singleton
    fun provideMonListRepository(pokeApi: PokeApi): MonListRepository =
        MonListRepositoryImpl(pokeApi)

}