package com.example.whac_a_mole.domain

import com.example.whac_a_mole.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ScoreInteractorImpl @Inject constructor(
    private val dataRepositoryImpl: DataRepository
) : ScoreInteractor {
    override suspend fun getDataScores(): List<Scores> {
        return withContext(Dispatchers.IO) {
            dataRepositoryImpl.getScores()
        }
    }

    override suspend fun insertDataScore(score: Scores) {
        withContext(Dispatchers.IO) {
            dataRepositoryImpl.insertScores(score)
        }
    }
}