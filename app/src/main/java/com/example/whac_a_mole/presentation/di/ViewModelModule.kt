package com.example.whac_a_mole.presentation.di

import com.example.whac_a_mole.domain.ScoreInteractor
import com.example.whac_a_mole.presentation.SharedViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun providesSharedViewModel(
        interactor: ScoreInteractor
    ): SharedViewModel =
        SharedViewModel(scoreInteractor = interactor)
}