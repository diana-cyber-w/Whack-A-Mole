package com.example.whac_a_mole.data.di

import android.content.Context
import androidx.room.Room
import com.example.whac_a_mole.data.storage.AppDatabase
import com.example.whac_a_mole.data.storage.ScoreDao
import com.example.whac_a_mole.repository.DataRepository
import com.example.whac_a_mole.repository.DataRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun providesDatabaseBuilder(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "score"
        ).build()

    @Provides
    fun providesScoreDao(appDatabase: AppDatabase): ScoreDao =
        appDatabase.getScoreDao()

    @Provides
    fun providesDataRepositoryImpl(scoreDao: ScoreDao): DataRepository =
        DataRepositoryImpl(scoreDao = scoreDao)
}