package com.example.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel: ViewModel() {
    val firstNumber: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val secondNumber: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val action: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}