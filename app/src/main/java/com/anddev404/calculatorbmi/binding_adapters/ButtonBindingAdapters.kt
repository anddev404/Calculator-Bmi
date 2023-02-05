package com.anddev404.calculatorbmi.binding_adapters

import android.widget.Button
import androidx.databinding.BindingAdapter
import com.anddev404.calculatorbmi.R
import com.anddev404.calculatorbmi.data.model.WeightUnit


@BindingAdapter("weightUnit")
fun Button.setTextByWeightUnit(weightUnit: WeightUnit) {
    when (weightUnit) {
        WeightUnit.KG -> this.text = resources.getString(R.string.kg)
        WeightUnit.LB -> this.text = resources.getString(R.string.lb)
        WeightUnit.ST_LB -> this.text = resources.getString(R.string.st_lb)
    }
}
