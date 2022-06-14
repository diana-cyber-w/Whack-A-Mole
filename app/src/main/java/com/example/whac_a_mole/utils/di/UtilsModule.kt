package com.example.whac_a_mole.utils.di

import android.content.Context
import com.example.whac_a_mole.utils.SharedPreferenceManager
import com.example.whac_a_mole.utils.SharedPreferenceManagerImpl
import dagger.Module
import dagger.Provides

@Module
class UtilsModule {

    @Provides
    fun providesSharedPreferenceManager(context: Context): SharedPreferenceManager =
        SharedPreferenceManagerImpl(context)
}