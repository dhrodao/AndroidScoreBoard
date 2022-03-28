package com.dhrodao.androidlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dhrodao.androidlivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main)

        viewModel = ViewModelProvider(this)[ScoreViewModel::class.java]
        binding.viewModel = viewModel

        val scoreAObserver = Observer<Int> { newValue ->
            binding.scoreAText.text = newValue.toString()
        }

        viewModel.scoreTeamA.observe(this, scoreAObserver)

        val scoreBObserver = Observer<Int> { newValue ->
            binding.scoreBText.text = newValue.toString()
        }

        viewModel.scoreTeamB.observe(this, scoreBObserver)

        binding.scoreAButton.setOnClickListener {
            viewModel.addOneTeamA()
        }

        binding.scoreBButton.setOnClickListener {
            viewModel.addOneTeamB()
        }

        binding.resetButton.setOnClickListener {
            viewModel.resetScore()
        }
    }
}