package com.example.simplemorsecode.ui.flashlight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simplemorsecode.databinding.FragmentFlashlightBinding

class FlashlightFragment : Fragment() {

    private lateinit var flahlightViewModel: FlahlightViewModel
    private var _binding: FragmentFlashlightBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        flahlightViewModel =
            ViewModelProvider(this).get(FlahlightViewModel::class.java)

        _binding = FragmentFlashlightBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textFlashlight
        flahlightViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}