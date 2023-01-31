package com.anddev404.calculatorbmi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _height: MutableLiveData<Float> = MutableLiveData()
    val height: LiveData<Float> = _height

    private val _weight: MutableLiveData<Float> = MutableLiveData()
    val weight: LiveData<Float> = _weight

    init {

    }

    //region methods
    fun changeHeight(height: Float) {
        if (_height.value != height) {
            _height.value = height
        }
    }

    fun changeWeight(weight: Float) {
        if (_weight.value != weight) {
            _weight.value = weight
        }
    }
    //endregion

}