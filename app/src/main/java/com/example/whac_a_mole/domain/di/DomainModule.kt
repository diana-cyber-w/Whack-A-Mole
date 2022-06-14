package com.example.whac_a_mole.domain.di

import com.example.whac_a_mole.domain.ScoreInteractor
import com.example.whac_a_mole.domain.ScoreInteractorImpl
import com.example.whac_a_mole.repository.DataRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun providesScoreInteractor(
        dataRepositoryImpl: DataRepositoryImpl
    ): ScoreInteractor =
        ScoreInteractorImpl(
            dataRepositoryImpl = dataRepositoryImpl
        )
}