package com.example.whac_a_mole.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        ScoreEntity::class
    ],
    version = AppDatabase.VERSION
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val VERSION = 1
    }

    abstract fun getScoreDao(): ScoreDao
}