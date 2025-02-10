package com.example.healthcare.view.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.healthcare.R
import com.example.healthcare.view.ui.activity.productdetail.CustomOrder
import com.example.healthcare.view.ui.activity.productdetail.HealthCareProduct
import com.example.healthcare.view.ui.activity.productdetail.Prescription
import com.example.healthcare.view.ui.activity.productdetail.ProteinDetail
import com.example.healthcare.databinding.FragmentHomeTabBinding


class HomeFragmentTab : Fragment() {

    private lateinit var binding: FragmentHomeTabBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home_tab, container,
            false
        )
        binding.apply {
                protein.setOnClickListener {
                val intent = Intent(activity, ProteinDetail::class.java)
                startActivity(intent)
            }
        }
        binding.product.setOnClickListener {
            val intent = Intent(activity, HealthCareProduct::class.java)
            startActivity(intent)
        }
        binding.prescription.setOnClickListener {
            val intent = Intent(activity, Prescription::class.java)
            startActivity(intent)
        }
        binding.customOrder.setOnClickListener {
            val intent = Intent(activity, CustomOrder::class.java)
            startActivity(intent)
        }
        return binding.root
    }
}


