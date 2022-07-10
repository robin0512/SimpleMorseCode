package com.example.simplemorsecode.ui.learn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simplemorsecode.databinding.FragmentLearnBinding

class LearnFragment : Fragment() {

    private lateinit var learnViewModel: LearnViewModel
    private var _binding: FragmentLearnBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLearnBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textLearn

        learnViewModel =
            ViewModelProvider(this).get(LearnViewModel::class.java)
                .apply {
                    text.observe(viewLifecycleOwner, Observer {
                        textView.text = it
                    })
                }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}