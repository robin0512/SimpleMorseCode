package com.example.simplemorsecode.ui.flashlight

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplemorsecode.model.MorseData

class FlashlightViewModel : ViewModel() {
    private val model = MorseData()
    private val _text = MutableLiveData<String>().apply {
        value = "This is flashlight Fragment"
    }
    val text: LiveData<String> = _text
}