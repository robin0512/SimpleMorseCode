package com.example.simplemorsecode.ui.learn

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.os.Vibrator
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.simplemorsecode.databinding.FragmentLearnBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class LearnFragment : Fragment() {

    private lateinit var learnViewModel: LearnViewModel
    private var _binding: FragmentLearnBinding? = null
    private lateinit var cameraManager: CameraManager
    private lateinit var vibratorManager: Vibrator

    private val binding get() = _binding!!
    private var isFlashlightOn = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        learnViewModel =
            ViewModelProvider(this)[LearnViewModel::class.java]

        _binding = FragmentLearnBinding.inflate(inflater, container, false)

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            cameraManager = requireActivity().getSystemService(Context.CAMERA_SERVICE) as CameraManager
            vibratorManager = requireActivity().getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

            binding.btnAA.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("AA")
                }
            }
            binding.btnAB.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("AB")
                }
            }
            binding.btnABT.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("ABT")
                }
            }
            binding.btnADS.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("ADS")
                }
            }
            binding.btnAGN.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("AGN")
                }
            }
            binding.btnC.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("C")
                }
            }
            binding.btnCFM.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("CFM")
                }
            }
            binding.btnCLG.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("CLG")
                }
            }
            binding.btnCUL.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("CUL")
                }
            }
            binding.btnCUZ.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("CUZ")
                }
            }
            binding.btnDE.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("DE")
                }
            }
            binding.btnDX.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("DX")
                }
            }
            binding.btnES.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("ES")
                }
            }
            binding.btnGA.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("GA")
                }
            }
            binding.btnGE.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("GE")
                }
            }
            binding.btnGM.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("GM")
                }
            }
            binding.btnGUD.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("GUD")
                }
            }
            binding.btnHR.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("HR")
                }
            }
            binding.btnHV.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("HV")
                }
            }
            binding.btnPSE.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("PSE")
                }
            }
            binding.btnR.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("R")
                }
            }
            binding.btnSN.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("SN")
                }
            }
            binding.btnSRI.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("SRI")
                }
            }
            binding.btnSOS.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("SOS")
                }
            }
            binding.btnTNX.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("TNX")
                }
            }

        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private suspend fun flashBinaryMessage(message: String) {
        val messageInBinary = learnViewModel.convertToBinary(message.uppercase(Locale.ROOT))
        Log.d("HAHA", "Message is $message, in binary is $messageInBinary")
        messageInBinary.forEach {
            when (it) {
                '/' -> pause(DEFAULT_DELAY_WORDS)
                '-' -> pause(DEFAULT_DELAY_LETTERS)
                else -> {
                    when (it) {
                        '0' -> blink(DEFAULT_LENGTH_ONE_UNIT_MILLISECONDS)
                        '1' -> blink(DEFAULT_LENGTH_DASH)
                        else -> print("error")
                    }
                    pause(DEFAULT_LENGTH_ONE_UNIT_MILLISECONDS)
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private suspend fun blink(delay: Long = DEFAULT_LENGTH_ONE_UNIT_MILLISECONDS) {
        vibrateOn()
        flashLightOn()
        pause(delay)
        flashLightOff()
    }

    private suspend fun pause(delayTime: Long) {
        delay(delayTime)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun flashLightOn() {
        cameraManager.setTorchMode(cameraManager.cameraIdList.first(), true)
        isFlashlightOn = true
    }

    private fun vibrateOn() {
        vibratorManager.vibrate(100)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun flashLightOff() {
        cameraManager.setTorchMode(cameraManager.cameraIdList.first(), false)
        isFlashlightOn = false
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        learnViewModel = ViewModelProvider(this)[LearnViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val DEFAULT_LENGTH_ONE_UNIT_MILLISECONDS = 200L
        private const val DEFAULT_LENGTH_DASH = DEFAULT_LENGTH_ONE_UNIT_MILLISECONDS * 3
        private const val DEFAULT_DELAY_LETTERS = DEFAULT_LENGTH_ONE_UNIT_MILLISECONDS * 3
        private const val DEFAULT_DELAY_WORDS = DEFAULT_LENGTH_ONE_UNIT_MILLISECONDS * 7
    }
}