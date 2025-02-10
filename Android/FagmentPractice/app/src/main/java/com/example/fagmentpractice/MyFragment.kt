package com.example.fagmentpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fagmentpractice.databinding.FragmentBinding

class MyFragment : Fragment() {
    private lateinit var binding: FragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBinding.inflate(layoutInflater)
        return binding.root
    }

}