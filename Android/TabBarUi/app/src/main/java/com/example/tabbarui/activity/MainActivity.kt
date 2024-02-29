package com.example.tabbarui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.tabbarui.R
import com.example.tabbarui.databinding.ActivityMainBinding
import com.example.tabbarui.fragment.CallFragment
import com.example.tabbarui.fragment.ChatFragment
import com.example.tabbarui.fragment.HomeFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        tabBar()
        loadHomeFragment()
        initClickListeners()
    }

    private fun loadHomeFragment() {
        replaceFragment(HomeFragment.onNewInstance())
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    private fun tabBar() {
        binding.tabLayout.getTabAt(0)!!.setText("Home")
        binding.tabLayout.getTabAt(1)!!.setText("Chat")
        binding.tabLayout.getTabAt(2)!!.setText("Call")
    }

    private fun initClickListeners() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        loadHomeFragment()
                    }

                    1 -> {

                        replaceFragment(ChatFragment.onNewInstance())
                    }

                    2 -> {

                        replaceFragment(CallFragment.onNewInstance())
                    }

                }
            }
        })
    }
}