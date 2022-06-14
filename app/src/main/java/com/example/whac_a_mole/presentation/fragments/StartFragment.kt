package com.example.whac_a_mole.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.whac_a_mole.DaggerApplication
import com.example.whac_a_mole.R
import com.example.whac_a_mole.databinding.StartLayoutBinding
import com.example.whac_a_mole.presentation.SharedViewModel
import com.example.whac_a_mole.utils.SharedPreferenceManager
import javax.inject.Inject

class StartFragment : Fragment(R.layout.start_layout) {

    private val binding: StartLayoutBinding by viewBinding(StartLayoutBinding::bind)
    private var maxScore = 0

    @Inject
    lateinit var viewModel: SharedViewModel

    @Inject
    lateinit var prefs: SharedPreferenceManager

    init {
        DaggerApplication.appComponent?.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.playButton.setOnClickListener {
            findNavController().navigate(R.id.toPlay)
        }
        viewModel.loadDatabaseScores()
        initObserves()
    }

    private fun initObserves() {
        viewModel.scores.observe(viewLifecycleOwner) { scoresList ->
            scoresList.forEach { scores ->
                if (scores.score > maxScore) {
                    maxScore = scores.score
                }
            }
            binding.records.text = maxScore.toString()
        }
    }
}