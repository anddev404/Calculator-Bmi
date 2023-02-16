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
import com.anddev404.calculatorbmi.databinding.FragmentKgBinding
import com.anddev404.calculatorbmi.extensions.toFloatOrZero

class KgFragment : Fragment() {

    private lateinit var viewmodel: SharedViewModel
    private lateinit var binding: FragmentKgBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewmodel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        binding = FragmentKgBinding.inflate(inflater, container, false).apply {
            viewmodel = this@KgFragment.viewmodel
            lifecycleOwner = this@KgFragment
        }
        binding.kgEditText.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                viewmodel.changeWeight(p0.toString().toFloatOrZero())
            }
        })

        return binding.root
    }
}