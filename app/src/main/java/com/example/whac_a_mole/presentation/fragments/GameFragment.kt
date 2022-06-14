package com.example.whac_a_mole.presentation.fragments

import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.whac_a_mole.DaggerApplication
import com.example.whac_a_mole.R
import com.example.whac_a_mole.databinding.GameLayoutBinding
import com.example.whac_a_mole.domain.Scores
import com.example.whac_a_mole.presentation.SharedViewModel
import com.example.whac_a_mole.utils.SharedPreferenceManager
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class GameFragment : Fragment(R.layout.game_layout) {

    private val binding: GameLayoutBinding by viewBinding(GameLayoutBinding::bind)
    private var timer: CountDownTimer? = null
    private var moleTimer: CountDownTimer? = null
    private var counter = 0

    @Inject
    lateinit var viewModel: SharedViewModel

    @Inject
    lateinit var prefs: SharedPreferenceManager

    init {
        DaggerApplication.appComponent?.inject(this)
    }

    override fun onResume() {
        super.onResume()
        startCountDownTimer()
    }

    private fun startCountDownTimer() {
        timer?.cancel()
        timer = object : CountDownTimer(30000, 1000) {
            override fun onTick(time: Long) {
                val timeInSeconds = TimeUnit.MILLISECONDS.toSeconds(time)
                binding.time.text = timeInSeconds.toString()
                startGame()
            }

            override fun onFinish() {
                val scores = Scores(prefs.getInt(COUNTER_KEY))
                viewModel.insertScores(scores)
                findNavController().navigate(R.id.toResults)
            }
        }.start()
    }

    private fun startGame() {
        val moles = listOf(
            binding.mole1,
            binding.mole2,
            binding.mole3,
            binding.mole4,
            binding.mole5,
            binding.mole6
        )

        moleTimer?.cancel()
        prefs.saveInt(INT_KEY, (0..5).random())
        moleTimer = object : CountDownTimer(500, 500) {
            override fun onTick(p0: Long) {
                moles[prefs.getInt(INT_KEY)].visibility = View.VISIBLE
                moles[prefs.getInt(INT_KEY)].isEnabled = true
                moles[prefs.getInt(INT_KEY)].isClickable = true
                moles[prefs.getInt(INT_KEY)].setOnClickListener {
                    counter++
                    prefs.saveInt(COUNTER_KEY, counter)
                    binding.counter.text = counter.toString()
                }
            }

            override fun onFinish() {
                moles[prefs.getInt(INT_KEY)].visibility = View.INVISIBLE
                moles[prefs.getInt(INT_KEY)].isEnabled = false
                moles[prefs.getInt(INT_KEY)].isClickable = false
            }
        }.start()
    }

    companion object {
        private const val INT_KEY = "mole key"
        private const val COUNTER_KEY = "counter key"
    }
}