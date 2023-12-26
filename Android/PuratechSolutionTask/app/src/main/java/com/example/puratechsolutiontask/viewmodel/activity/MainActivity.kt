package com.example.puratechsolutiontask.viewmodel.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.puratechsolutiontask.R
import com.example.puratechsolutiontask.databinding.ActivityMainBinding
import com.example.puratechsolutiontask.viewmodel.fragment.Account
import com.example.puratechsolutiontask.viewmodel.fragment.Cart
import com.example.puratechsolutiontask.viewmodel.fragment.HomeFragmentTab
import com.google.android.material.navigation.NavigationView
import android.icu.text.Replaceable as Replaceable1


class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        fun AppCompatActivity.replaceFragment(fragment: Fragment){
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            //transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.account -> replaceFragment(Account())
                R.id.cart -> replaceFragment(Cart())
                R.id.home -> replaceFragment(HomeFragmentTab())
                else -> {
                    replaceFragment(HomeFragmentTab())
                }
            }
            true
        }



        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {

            when (it.itemId) {




                R.id.nav_home -> Toast.makeText(
                    applicationContext,
                    "Clicked Home",
                    Toast.LENGTH_LONG
                ).show()

                R.id.nav_message -> Toast.makeText(
                    applicationContext,
                    "Clicked Message",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.nav_sync -> Toast.makeText(
                    applicationContext,
                    "Clicked Sync",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.nav_trash -> Toast.makeText(
                    applicationContext,
                    "Clicked Trash",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.nav_setting -> Toast.makeText(
                    applicationContext,
                    "Clicked Setting",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.nav_logout -> Toast.makeText(
                    applicationContext,
                    "Clicked Login",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.nav_share -> Toast.makeText(
                    applicationContext,
                    "Clicked Share",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.nav_rate -> Toast.makeText(
                    applicationContext,
                    "Clicked Rate Us",
                    Toast.LENGTH_SHORT
                ).show()
            }
            true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}