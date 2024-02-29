package com.example.onboarding.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.phonepe.R
import com.example.phonepe.databinding.FragmentWealthBinding

class WealthFragment : Fragment() {

    private lateinit var binding: FragmentWealthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_wealth, container, false)
        return binding.root
    }

    companion object {
        fun onNewInstance(): WealthFragment {
            val fragment = WealthFragment()
            return fragment

        }
    }
}