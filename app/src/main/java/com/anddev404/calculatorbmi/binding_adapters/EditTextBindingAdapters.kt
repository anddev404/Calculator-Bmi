package com.anddev404.calculatorbmi.binding_adapters

import android.widget.EditText
import androidx.databinding.BindingAdapter
import com.anddev404.calculatorbmi.extensions.toFloatOrZero
import com.anddev404.calculatorbmi.extensions.toIntOrZero
import com.anddev404.calculatorbmi.tools.UnitConverter

@BindingAdapter("height_cm")
fun EditText.setHeightInCm(heightInCm: Float) {

    val previousText = this.text.toString().toFloatOrZero()
    if (previousText == heightInCm) return

    this.setText("$heightInCm")
}

@BindingAdapter("height_ft")
fun EditText.setHeightInFt(heightInCm: Float) {

    val previousFeet = this.text.toString().toIntOrZero()
    val actualFeet = (UnitConverter.cmToInches(heightInCm)) / 12

    if (previousFeet == actualFeet) return
    this.setText("$actualFeet")

}

@BindingAdapter("height_in")
fun EditText.setHeightInInches(heightInCm: Float) {

    val previousInches = this.text.toString().toIntOrZero()
    val actualInches = (UnitConverter.cmToInches(heightInCm)) % 12

    if (previousInches == actualInches) return
    this.setText("$actualInches")

}

@BindingAdapter("height_only_in")
fun EditText.setHeightOnlyInInches(heightInCm: Float) {

    val previousInches = this.text.toString().toIntOrZero()
    val actualInches = (UnitConverter.cmToInches(heightInCm))

    if (previousInches == actualInches) return
    this.setText("$actualInches")

}