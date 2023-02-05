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

    private lateinit var viewmodel: SharedViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewmodel = ViewModelProvider(this)[SharedViewModel::class.java]

        binding = DataBindingUtil.setContentView<ActivityMainBinding?>(this, R.layout.activity_main)
            .apply {
                viewmodel = this@MainActivity.viewmodel
                lifecycleOwner = this@MainActivity
            }

        hideActionBar()
        addMenuButtonsClickListener()
    }

    private fun hideActionBar() {
        supportActionBar?.hide()
    }

    private fun addMenuButtonsClickListener() {

        binding.changeHeightUnitButton.setOnClickListener {
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

        binding.changeWeightUnitButton.setOnClickListener {
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