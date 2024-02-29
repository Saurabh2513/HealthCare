package com.example.onboarding.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.app.Base.MyApplication
import com.example.onboarding.fragment.CreditFragment
import com.example.onboarding.fragment.HistoryFragment
import com.example.onboarding.fragment.HomeFragment
import com.example.onboarding.fragment.InsuranceFragment
import com.example.onboarding.fragment.WealthFragment
import com.example.onboarding.viewholder.SendMoneyHolder
import com.example.phonepe.R
import com.example.phonepe.databinding.ActivityMainBinding
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.MaterialShapeDrawable.SHADOW_COMPAT_MODE_ALWAYS
import com.google.android.material.tabs.TabLayout

open class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var obj = MyApplication.instance
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        tabBar()
        loadHomeFragment()
        initClickListeners()
        setSupportActionBar(binding.toolbar)
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
        val background = binding.tabLayout.background
        if (background is MaterialShapeDrawable) {
            background.shadowCompatibilityMode = SHADOW_COMPAT_MODE_ALWAYS
        }
        binding.tabLayout.getTabAt(0)!!.setText("Home")
        binding.tabLayout.getTabAt(0)!!.setIcon(R.drawable.home_icon)
        binding.tabLayout.getTabAt(1)!!.setText("Credit")
        binding.tabLayout.getTabAt(1)!!.setIcon(R.drawable.rupee)
        binding.tabLayout.getTabAt(2)!!.setText("Insurance")
        binding.tabLayout.getTabAt(2)!!.setIcon(R.drawable.security)
        binding.tabLayout.getTabAt(3)!!.setText("Wealth")
        binding.tabLayout.getTabAt(3)!!.setIcon(R.drawable.wealth)
        binding.tabLayout.getTabAt(4)!!.setText("History")
        binding.tabLayout.getTabAt(4)!!.setIcon(R.drawable.exchange)


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

                        replaceFragment(CreditFragment.onNewInstance())
                    }

                    2 -> {

                        replaceFragment(InsuranceFragment.onNewInstance())
                    }

                    3 -> {

                        replaceFragment(WealthFragment.onNewInstance())
                    }

                    4 -> {

                        replaceFragment(HistoryFragment.onNewInstance())
                    }

                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.question -> {
                Toast.makeText(this, "Question", Toast.LENGTH_LONG).show()
                return true
            }

            R.id.notification -> {
                Toast.makeText(this, "Notification", Toast.LENGTH_LONG).show()
                return true
            }

            R.id.scanner -> {
                Toast.makeText(this, "QR Code", Toast.LENGTH_LONG).show()
                return true
            }


            else -> super.onOptionsItemSelected(item)
        }

    }



}