package com.anddev404.calculatorbmi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.anddev404.calculatorbmi.data.model.HeightUnit
import com.anddev404.calculatorbmi.data.model.WeightUnit
import com.anddev404.calculatorbmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /**
    Główna aktywność projektu, wykorzystująca shared ViewModel oraz data binding.
    Ta aktywność zawiera także setOnClickListeners menu przycisków, umożliwiających zmianę jednostki miary - wagi lub wzrostu, co skutkuje
    zmianą fragmentów we FragmentContainerView.

    Layout tej aktywności składa się z trzech CardView-ów.
    Pierwszy służy do wprowadzania danych od użytkownika,
    drugi zawiera wynik - czyli BMI,
    trzecii podaje informacje dotyczące wagi użytkownika, tj. wagę idealną, przedział wagi prawidłowej oraz nadwagę lub niedowagę.
     */

    private lateinit var viewmodel: SharedViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewmodel = ViewModelProvider(this)[SharedViewModel::class.java]

        binding = DataBindingUtil.setContentView<ActivityMainBinding?>(this, R.layout.activity_main)
            .apply {
                viewmodel = this@MainActivity.viewmodel
                supportFragmentManager = this@MainActivity.supportFragmentManager
                lifecycleOwner = this@MainActivity
            }

        hideActionBar()
        addMenuButtonsClickListener()
    }

    private fun hideActionBar() {
        supportActionBar?.hide()
    }

    private fun addMenuButtonsClickListener() {

        binding.topView.changeHeightUnitButton.setOnClickListener {
            val popup = PopupMenu(this, it)
            popup.menuInflater.inflate(R.menu.height_popup_menu, popup.menu)

            popup.setOnMenuItemClickListener {
                when (it.title) {
                    resources.getString(R.string.cm) ->
                        viewmodel.changeHeightUnit(HeightUnit.CM)

                    resources.getString(R.string.`in`) ->
                        viewmodel.changeHeightUnit(HeightUnit.IN)

                    resources.getString(R.string.ft_in) ->
                        viewmodel.changeHeightUnit(HeightUnit.FT_IN)
                }
                true
            }
            popup.show()
        }

        binding.topView.changeWeightUnitButton.setOnClickListener {
            val popup = PopupMenu(this, it)
            popup.menuInflater.inflate(R.menu.weight_popup_menu, popup.menu)

            popup.setOnMenuItemClickListener { menuItem ->
                when (menuItem.title) {
                    resources.getString(R.string.kg) -> {
                        viewmodel.changeWeightUnit(WeightUnit.KG)
                    }
                    resources.getString(R.string.lb) -> {
                        viewmodel.changeWeightUnit(WeightUnit.LB)
                    }
                    resources.getString(R.string.st_lb) -> {
                        viewmodel.changeWeightUnit(WeightUnit.ST_LB)
                    }
                }
                true
            }
            popup.show()
        }
    }
}