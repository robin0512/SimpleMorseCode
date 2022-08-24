package com.example.simplemorsecode.ui.flashlight

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
import com.example.simplemorsecode.databinding.FragmentFlashlightBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*


class FlashlightFragment : Fragment() {

    private lateinit var flashlightViewModel: FlashlightViewModel
    private var _binding: FragmentFlashlightBinding? = null
    private lateinit var cameraManager: CameraManager
    private lateinit var vibratorManager: Vibrator

    private val binding get() = _binding!!
    private var isFlashlightOn = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        flashlightViewModel =
            ViewModelProvider(this)[FlashlightViewModel::class.java]

        _binding = FragmentFlashlightBinding.inflate(inflater, container, false)

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            cameraManager = requireActivity().getSystemService(Context.CAMERA_SERVICE) as CameraManager
            vibratorManager = requireActivity().getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

            binding.btnA.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("A")
                }
            }
            binding.btnB.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("B")
                }
            }
            binding.btnC.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("C")
                }
            }
            binding.btnD.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("D")
                }
            }
            binding.btnE.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("E")
                }
            }
            binding.btnF.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("F")
                }
            }
            binding.btnG.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("G")
                }
            }
            binding.btnH.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("H")
                }
            }
            binding.btnI.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("I")
                }
            }
            binding.btnJ.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("J")
                }
            }
            binding.btnK.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("K")
                }
            }
            binding.btnL.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("L")
                }
            }
            binding.btnM.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("M")
                }
            }
            binding.btnN.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("N")
                }
            }
            binding.btnO.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("O")
                }
            }
            binding.btnP.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("P")
                }
            }
            binding.btnQ.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("Q")
                }
            }
            binding.btnR.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("R")
                }
            }
            binding.btnS.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("S")
                }
            }
            binding.btnT.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("T")
                }
            }
            binding.btnU.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("U")
                }
            }
            binding.btnV.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("V")
                }
            }
            binding.btnW.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("W")
                }
            }
            binding.btnX.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("X")
                }
            }
            binding.btnY.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("Y")
                }
            }
            binding.btnZ.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("Z")
                }
            }
            binding.btn0.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("0")
                }
            }
            binding.btn1.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("1")
                }
            }
            binding.btn2.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("2")
                }
            }
            binding.btn3.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("3")
                }
            }
            binding.btn4.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("4")
                }
            }
            binding.btn5.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("5")
                }
            }
            binding.btn6.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("6")
                }
            }
            binding.btn7.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("7")
                }
            }
            binding.btn8.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("8")
                }
            }
            binding.btn9.setOnClickListener {
                lifecycleScope.launch {
                    flashBinaryMessage("9")
                }
            }
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private suspend fun flashBinaryMessage(message: String) {
        val messageInBinary = flashlightViewModel.convertToBinary(message.uppercase(Locale.ROOT))
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
        flashlightViewModel = ViewModelProvider(this)[FlashlightViewModel::class.java]
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