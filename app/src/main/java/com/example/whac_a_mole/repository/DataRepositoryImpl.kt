package com.example.whac_a_mole.repository

import com.example.whac_a_mole.data.storage.ScoreDao
import com.example.whac_a_mole.domain.Scores
import com.example.whac_a_mole.domain.toScoreEntity
import com.example.whac_a_mole.domain.toScores
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(private val scoreDao: ScoreDao) : DataRepository {
    override suspend fun getScores(): List<Scores> {
        return withContext(Dispatchers.IO) {
            scoreDao.getAllScores().map { scoreEntity ->
                scoreEntity.toScores()
            }
        }
    }

    override suspend fun insertScores(scores: Scores) {
        withContext(Dispatchers.IO) {
            scoreDao.insertScore(scores.toScoreEntity())
        }
    }
}