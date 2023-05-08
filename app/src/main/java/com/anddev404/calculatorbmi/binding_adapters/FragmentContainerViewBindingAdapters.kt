package com.anddev404.calculatorbmi.binding_adapters

import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import com.anddev404.calculatorbmi.R
import com.anddev404.calculatorbmi.data.model.HeightUnit
import com.anddev404.calculatorbmi.data.model.WeightUnit
import com.anddev404.calculatorbmi.fragments.*

/**
 * Poniższe metody showFragmentByHeightUnit oraz showFragmentByWeightUnit
 * są odpowiedzialne za wyświetlanie odpowiednich fragmentów związanych z jednostką wagi i wzrostu.
 * Wymagają FragmentManagera przesłanego z aktywności, która korzysta z FragmentContainerView,
 * w celu przypisania fragmentu do kontenera.
 */

@BindingAdapter("heightFragment", "fragmentManager")
fun FragmentContainerView.showFragmentByHeightUnit(
    heightUnit: HeightUnit,
    fragmentManager: FragmentManager
) {
    when (heightUnit) {

        HeightUnit.CM -> fragmentManager.beginTransaction()
            .replace(R.id.height_fragment, CmFragment()).commit()

        HeightUnit.IN -> fragmentManager.beginTransaction()
            .replace(R.id.height_fragment, InFragment()).commit()

        HeightUnit.FT_IN -> fragmentManager.beginTransaction()
            .replace(R.id.height_fragment, FtInFragment()).commit()
    }
}

@BindingAdapter("weightFragment", "fragmentManager")
fun FragmentContainerView.showFragmentByWeightUnit(
    weightUnit: WeightUnit,
    fragmentManager: FragmentManager
) {
    when (weightUnit) {

        WeightUnit.KG -> fragmentManager.beginTransaction()
            .replace(R.id.weight_fragment, KgFragment()).commit()

        WeightUnit.LB -> fragmentManager.beginTransaction()
            .replace(R.id.weight_fragment, LbFragment()).commit()

        WeightUnit.ST_LB -> fragmentManager.beginTransaction()
            .replace(R.id.weight_fragment, StLbFragment()).commit()
    }
}