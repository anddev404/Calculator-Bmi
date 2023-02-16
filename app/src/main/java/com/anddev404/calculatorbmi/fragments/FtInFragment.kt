package com.anddev404.calculatorbmi.fragments

import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.Spanned
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.anddev404.calculatorbmi.SharedViewModel
import com.anddev404.calculatorbmi.databinding.FragmentFtInBinding
import com.anddev404.calculatorbmi.extensions.toIntOrZero
import com.anddev404.calculatorbmi.tools.UnitConverter

class FtInFragment : Fragment() {

    private lateinit var viewmodel: SharedViewModel
    private lateinit var binding: FragmentFtInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRetainInstance(true);
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewmodel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        binding = FragmentFtInBinding.inflate(inflater, container, false).apply {
            viewmodel = this@FtInFragment.viewmodel
            lifecycleOwner = this@FtInFragment
        }

        binding.footEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {

                var foots = 0
                if (p0.toString() != "") foots = p0.toString().toIntOrZero()

                val inches = binding.inEditText.text.toString().toIntOrZero()
                val cm = UnitConverter.inchesToCm(inches + (foots * 12))

                viewmodel.changeHeight(cm)
            }
        })

        binding.inEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {

                var inches = 0

                if (p0.toString() != "") inches = p0.toString().toIntOrZero()

                val foots = binding.footEditText.text.toString().toIntOrZero()
                val cm = UnitConverter.inchesToCm(inches + (foots * 12))

                viewmodel.changeHeight(cm)
            }
        })
        binding.inEditText.filters = arrayOf<InputFilter>(MinMaxFilter(0, 11))

        return binding.root
    }

    //region stackoverflow code
    inner class MinMaxFilter() : InputFilter {
        private var intMin: Int = 0
        private var intMax: Int = 0

        constructor(minValue: Int, maxValue: Int) : this() {
            this.intMin = minValue
            this.intMax = maxValue
        }

        override fun filter(
            source: CharSequence,
            start: Int,
            end: Int,
            dest: Spanned,
            dStart: Int,
            dEnd: Int
        ): CharSequence? {
            try {
                val input = Integer.parseInt(dest.toString() + source.toString())
                if (isInRange(intMin, intMax, input)) {
                    return null
                }
            } catch (e: NumberFormatException) {
                e.printStackTrace()
            }
            return ""
        }

        private fun isInRange(a: Int, b: Int, c: Int): Boolean {
            return if (b > a) c in a..b else c in b..a
        }
    }
    //endregion
}