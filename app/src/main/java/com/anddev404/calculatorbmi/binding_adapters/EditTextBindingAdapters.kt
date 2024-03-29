package com.anddev404.calculatorbmi.binding_adapters

import android.widget.EditText
import androidx.databinding.BindingAdapter
import com.anddev404.calculatorbmi.extensions.toFloatOrZero
import com.anddev404.calculatorbmi.extensions.toIntOrZero
import com.anddev404.calculatorbmi.tools.UnitConverter

/**
 * Do obliczenia BMI wymagane jest podanie wzrostu w [cm] oraz wagi w [kg].
 * Dlatego ViewModel korzysta z tych jednostek, a w przypadku użycia innych jednostek,
 * takich jak funt, cale, stone, lb itp., wymagana jest ich konwersja.
 * Poniższe metody konwertują wartości wzrostu i wagi z jednostek innych niż cm i kg na odpowiadające im wartości.
 * W celu uniknięcia pętli w aplikacji podczas wysyłania danych do EditText-ów
 * z użyciem addTextChangedListener i TextWatcher-a, wartości te są porównywane przed przekazaniem ich do EditText-ów.
 */
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

@BindingAdapter("weight_kg")
fun EditText.setWeightInKg(weightInKg: Float) {

    val previousKg = this.text.toString().toFloatOrZero()
    if (previousKg == weightInKg) return

    this.setText("$weightInKg")
}

@BindingAdapter("weight_st")
fun EditText.setWeightInSt(weightInKg: Float) {

    val previousStones = this.text.toString().toIntOrZero()
    val actualStones = (UnitConverter.kgToLb(weightInKg)) / 14

    if (previousStones == actualStones) return
    this.setText("$actualStones")

}

@BindingAdapter("weight_lb")
fun EditText.setWeightInLbs(weightInKg: Float) {

    val previousLbs = this.text.toString().toIntOrZero()
    val actualLbs = (UnitConverter.kgToLb(weightInKg)) % 14

    if (previousLbs == actualLbs) return
    this.setText("$actualLbs")

}

@BindingAdapter("weight_only_lb")
fun EditText.setWeightOnlyInLb(weightInKg: Float) {

    val previousLbs = this.text.toString().toIntOrZero()
    val actualLbs = (UnitConverter.kgToLb(weightInKg))

    if (previousLbs == actualLbs) return
    this.setText("$actualLbs")

}