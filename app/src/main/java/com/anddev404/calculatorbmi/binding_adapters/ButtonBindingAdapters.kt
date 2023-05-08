package com.anddev404.calculatorbmi.binding_adapters

import android.widget.Button
import androidx.databinding.BindingAdapter
import com.anddev404.calculatorbmi.R
import com.anddev404.calculatorbmi.data.model.HeightUnit
import com.anddev404.calculatorbmi.data.model.WeightUnit

/**
 * Metody setTextByHeightUnit oraz setTextByWeightUnit po zmianie jednostki wagi lub wzrostu
 * wyświetlają odpowiedni tekst (jednostkę wagi/wzrostu) na przycisku, z którego zostały wybrane.
 */
@BindingAdapter("heightUnit")
fun Button.setTextByHeightUnit(heightUnit: HeightUnit) {
    when (heightUnit) {
        HeightUnit.CM -> this.text = resources.getString(R.string.cm)
        HeightUnit.IN -> this.text = resources.getString(R.string.`in`)
        HeightUnit.FT_IN -> this.text = resources.getString(R.string.ft_in)
    }
}

@BindingAdapter("weightUnit")
fun Button.setTextByWeightUnit(weightUnit: WeightUnit) {
    when (weightUnit) {
        WeightUnit.KG -> this.text = resources.getString(R.string.kg)
        WeightUnit.LB -> this.text = resources.getString(R.string.lb)
        WeightUnit.ST_LB -> this.text = resources.getString(R.string.st_lb)
    }
}
