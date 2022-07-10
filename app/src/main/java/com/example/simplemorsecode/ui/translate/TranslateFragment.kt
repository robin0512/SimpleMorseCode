package com.example.simplemorsecode.ui.translate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simplemorsecode.databinding.FragmentTranslateBinding

class TranslateFragment : Fragment() {

    private lateinit var translateViewModel: TranslateViewModel
    private var _binding: FragmentTranslateBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTranslateBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTranslate

        translateViewModel =
            ViewModelProvider(this).get(TranslateViewModel::class.java)
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