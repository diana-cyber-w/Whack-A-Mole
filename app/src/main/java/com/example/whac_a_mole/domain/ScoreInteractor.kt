package com.example.whac_a_mole.domain

interface ScoreInteractor {
    suspend fun getDataScores(): List<Scores>

    suspend fun insertDataScore(score: Scores)
}