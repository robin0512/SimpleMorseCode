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
            cameraManager = activity!!.getSystemService(Context.CAMERA_SERVICE) as CameraManager
            vibratorManager = activity!!.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

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