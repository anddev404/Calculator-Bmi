package com.anddev404.calculatorbmi

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.anddev404.calculatorbmi.data.model.WeightUnit
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SharedViewModelTest {

    lateinit var viewModel: SharedViewModel

    lateinit var bmiLiveData: LiveData<Float>
    lateinit var idealWeightLiveData: LiveData<String>
    lateinit var correctWeightLiveData: LiveData<String>
    lateinit var underOverWeightLiveData: LiveData<Pair<Float, String>>

    lateinit var bmiObserver: Observer<Float>
    lateinit var idealWeightObserver: Observer<String>
    lateinit var correctWeightObserver: Observer<String>
    lateinit var underOverWeightObserver: Observer<Pair<Float, String>>


    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        viewModel = SharedViewModel()
        bmiLiveData = viewModel.bmi
        idealWeightLiveData = viewModel.idealWeight
        correctWeightLiveData = viewModel.correctWeight
        underOverWeightLiveData = viewModel.underOverWeight

    }

    @Test
    fun bmi() {
        bmiObserver = Observer {
            TestCase.assertEquals(24.22f, it, 0.01f)
        }
        idealWeightObserver = Observer {
            TestCase.assertEquals("62.9 kg", it)
        }
        correctWeightObserver = Observer {
            TestCase.assertEquals("53.5 kg -...\n...- 72.3 kg", it)
        }
        underOverWeightObserver = Observer {
            TestCase.assertEquals(0.0f, it.first)
            TestCase.assertEquals("...", it.second)
        }

        bmiLiveData.observeForever(bmiObserver)
        idealWeightLiveData.observeForever(idealWeightObserver)
        correctWeightLiveData.observeForever(correctWeightObserver)
        underOverWeightLiveData.observeForever(underOverWeightObserver)

        viewModel.changeWeightUnit(WeightUnit.KG)
        viewModel.changeHeight(170f)
        viewModel.changeWeight(70f)
    }

    @After
    fun teardown() {
        bmiLiveData.removeObserver(bmiObserver)
        idealWeightLiveData.removeObserver(idealWeightObserver)
        correctWeightLiveData.removeObserver(correctWeightObserver)
        underOverWeightLiveData.removeObserver(underOverWeightObserver)
    }
}