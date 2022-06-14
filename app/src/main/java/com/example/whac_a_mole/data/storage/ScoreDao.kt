package com.example.whac_a_mole.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ScoreDao {

    @Query("SELECT * FROM score")
    fun getAllScores(): List<ScoreEntity>

    @Insert
    fun insertScore(scores: ScoreEntity)
}