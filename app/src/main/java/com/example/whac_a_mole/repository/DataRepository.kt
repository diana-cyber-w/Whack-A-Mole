package com.example.whac_a_mole.repository

import com.example.whac_a_mole.domain.Scores

interface DataRepository {
    suspend fun getScores(): List<Scores>

    suspend fun insertScores(scores: Scores)
}