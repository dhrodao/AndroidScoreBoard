package com.dhrodao.androidlivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    private val _scoreTeamA : MutableLiveData<Int> = MutableLiveData(0)
    val scoreTeamA : LiveData<Int> = _scoreTeamA

    private val _scoreTeamB : MutableLiveData<Int> = MutableLiveData(0)
    val scoreTeamB : LiveData<Int> = _scoreTeamB

    fun addOneTeamA() {
        _scoreTeamA.value = _scoreTeamA.value?.plus(1)
    }

    fun addOneTeamB() {
        _scoreTeamB.value = _scoreTeamB.value?.plus(1)
    }

    fun resetScore() {
        _scoreTeamA.value = 0
        _scoreTeamB.value = 0
    }
}