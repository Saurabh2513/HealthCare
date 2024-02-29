package com.example.tabbarui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.tabbarui.R
import com.example.tabbarui.databinding.FragmentCallBinding

class CallFragment : Fragment() {
    private lateinit var binding: FragmentCallBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_call, container, false)
        return binding.root
    }

    companion object {
        fun onNewInstance(): CallFragment {
            val fragment = CallFragment()
            return fragment
        }
    }
}