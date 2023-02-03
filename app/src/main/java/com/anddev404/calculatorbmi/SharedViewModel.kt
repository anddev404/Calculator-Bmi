package com.anddev404.calculatorbmi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anddev404.calculatorbmi.data.model.WeightUnit
import com.anddev404.calculatorbmi.tools.CalculatorTools
import com.anddev404.calculatorbmi.tools.UnitConverter

class SharedViewModel : ViewModel() {

    private val _height: MutableLiveData<Float> = MutableLiveData(180f)//TODO delete temporary value
    val height: LiveData<Float> = _height

    private val _weight: MutableLiveData<Float> = MutableLiveData(80f)//TODO delete temporary value
    val weight: LiveData<Float> = _weight

    private val _weightUnit: MutableLiveData<WeightUnit> = MutableLiveData(WeightUnit.KG)

    val idealWeight = MediatorLiveData<String>()

    val bmi = MediatorLiveData<Float>()

    init {
        bmi.apply {

            addSource(_height) { height ->
                _weight.value?.let { weight ->
                    value = CalculatorTools.calculateBmi(height, weight)
                }
            }
            addSource(_weight) { weight ->
                _height.value?.let { height ->
                    value = CalculatorTools.calculateBmi(height, weight)
                }
            }
        }

        idealWeight.apply {

            fun getIdealWeight(height: Float, weightUnit: WeightUnit): String {
                return if (height > 0) UnitConverter.convertWeight(
                    CalculatorTools.calculateIdealWeight(height), weightUnit
                )
                else "..."
            }

            addSource(_weightUnit) { weightUnit ->
                _height.value?.let { height ->
                    value = getIdealWeight(height, weightUnit)
                }
            }

            addSource(_height) { height ->
                _weightUnit.value?.let { weightUnit ->
                    value = getIdealWeight(height, weightUnit)
                }
            }
        }
    }

    //region methods
    fun changeHeight(height: Float) {
        if (_height.value != height) {
            _height.postValue(height)
        }
    }

    fun changeWeight(weight: Float) {
        if (_weight.value != weight) {
            _weight.postValue(weight)
        }
    }

    fun changeWeightUnit(unit: WeightUnit) {
        _weightUnit.postValue(unit)
    }
    //endregion

}