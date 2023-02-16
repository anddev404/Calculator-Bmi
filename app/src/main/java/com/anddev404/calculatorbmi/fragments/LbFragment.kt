package com.anddev404.calculatorbmi.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.anddev404.calculatorbmi.SharedViewModel
import com.anddev404.calculatorbmi.databinding.FragmentLbBinding
import com.anddev404.calculatorbmi.extensions.toIntOrZero
import com.anddev404.calculatorbmi.tools.UnitConverter

class LbFragment : Fragment() {

    private lateinit var viewmodel: SharedViewModel
    private lateinit var binding: FragmentLbBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewmodel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        binding = FragmentLbBinding.inflate(inflater, container, false).apply {
            viewmodel = this@LbFragment.viewmodel
            lifecycleOwner = this@LbFragment
        }
        binding.lbEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                viewmodel.changeWeight(UnitConverter.lbToKg(p0.toString().toIntOrZero()))
            }
        })
        
        return binding.root
    }

}