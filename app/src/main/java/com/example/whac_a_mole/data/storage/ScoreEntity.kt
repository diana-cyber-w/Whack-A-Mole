package com.example.whac_a_mole.data.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "score")
data class ScoreEntity(

    @ColumnInfo(name = "score")
    val score: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}