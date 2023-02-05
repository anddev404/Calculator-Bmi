package com.anddev404.calculatorbmi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
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

    }

    private fun hideActionBar() {
        supportActionBar?.hide()
    }
}