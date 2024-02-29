package com.example.onboarding.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.phonepe.R
import com.example.phonepe.databinding.FragmentInsuranceBinding

class InsuranceFragment : Fragment() {

    private lateinit var binding: FragmentInsuranceBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_insurance, container,
            false
        )

        return binding.root
    }

    companion object {
        fun onNewInstance(): InsuranceFragment {
            val fragment = InsuranceFragment()
            return fragment
        }
    }
}