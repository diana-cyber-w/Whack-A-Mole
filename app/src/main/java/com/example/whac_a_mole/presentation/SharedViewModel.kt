package com.example.whac_a_mole.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whac_a_mole.domain.ScoreInteractor
import com.example.whac_a_mole.domain.Scores
import kotlinx.coroutines.launch
import javax.inject.Inject

class SharedViewModel @Inject constructor(
    private val scoreInteractor: ScoreInteractor
) : ViewModel() {

    val scores: LiveData<List<Scores>> get() = _scores
    private val _scores = MutableLiveData<List<Scores>>()

    fun loadDatabaseScores() {
        viewModelScope.launch {
            _scores.value = scoreInteractor.getDataScores()
        }
    }

    fun insertScores(score: Scores) {
        viewModelScope.launch {
            scoreInteractor.insertDataScore(score)
        }
    }
}