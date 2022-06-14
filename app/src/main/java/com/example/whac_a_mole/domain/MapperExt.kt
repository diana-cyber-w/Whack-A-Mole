package com.example.whac_a_mole.domain

import com.example.whac_a_mole.data.storage.ScoreEntity

fun ScoreEntity.toScores() =
    Scores(
        score = score
    )

fun Scores.toScoreEntity() =
    ScoreEntity(
        score = score
    )