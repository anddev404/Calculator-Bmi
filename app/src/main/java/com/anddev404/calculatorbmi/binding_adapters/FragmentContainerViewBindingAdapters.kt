package com.anddev404.calculatorbmi.binding_adapters

import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import com.anddev404.calculatorbmi.R
import com.anddev404.calculatorbmi.data.model.HeightUnit
import com.anddev404.calculatorbmi.fragments.CmFragment
import com.anddev404.calculatorbmi.fragments.FtInFragment
import com.anddev404.calculatorbmi.fragments.InFragment

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