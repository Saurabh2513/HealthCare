package com.example.onboarding.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import com.example.onboarding.activity.QrCodeActivity
import com.example.onboarding.activity.SendMoney
import com.example.phonepe.R
import com.example.phonepe.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflate(
            inflater, R.layout.fragment_home, container,
            false
        )

        binding.qrScannerBtn.setOnClickListener {
            val intent = Intent(activity, QrCodeActivity::class.java)
            startActivity(intent)
        }
        binding.imgToMobile.setOnClickListener {
            val intent = Intent(activity, SendMoney::class.java)
            startActivity(intent)
        }

        return binding.root
    }


    companion object {

        fun onNewInstance(): HomeFragment {
            val fragment = HomeFragment()
            return fragment
        }
    }
}