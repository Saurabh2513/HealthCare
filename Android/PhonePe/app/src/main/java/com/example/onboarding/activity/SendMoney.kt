package com.example.onboarding.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onboarding.adapter.SendMoneyAdapter
import com.example.onboarding.viewholder.SendMoneyHolder
import com.example.phonepe.R
import com.example.phonepe.databinding.ActivitySendMoneyBinding

open class SendMoney : AppCompatActivity() {

    private var isViewVisible = true
    private lateinit var binding: ActivitySendMoneyBinding
    private lateinit var sendMoneyAdapter: SendMoneyAdapter
    private lateinit var arrayContact: List<SendMoneyHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_money)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_send_money)

        loadSendMoney()
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.sendMoneyRecyclerView.setLayoutManager(layoutManager)
        sendMoneyAdapter = SendMoneyAdapter(arrayContact)
        binding.sendMoneyRecyclerView.adapter = sendMoneyAdapter


    }

    private fun loadSendMoney() {
        arrayContact = listOf(
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
            SendMoneyHolder("sagar", "money", 12.30),
        )
        //        binding.sendMoneyRecyclerView.layoutManager = LinearLayoutManager(this)
//        val arrayContact = ArrayList<SendMoneyHolder>()
//        for (i in 1..20) {
//            arrayContact.add(SendMoneyHolder(R.drawable.img1, "Sagar", "Hello gg", 12.30 + i))
//        }
        binding.sendMoneyRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                // Hide/show the toolbar based on the scroll direction
                if (dy > 0 && isViewVisible) {
                    // Scrolling down, hide the toolbar
                    hideToolbar()
                } else if (dy < 0 && !isViewVisible) {
                    // Scrolling up, show the toolbar
                    showToolbar()
                }
            }
        })


    }

    private fun hideToolbar() {
        // Your code to hide the toolbar goes here
        // For example, you can use the visibility property or animation
        // For simplicity, I'm setting the visibility to GONE
        binding.card.visibility = View.GONE
        isViewVisible = false
    }

    private fun showToolbar() {
        // Your code to show the toolbar goes here
        // For example, you can use the visibility property or animation
        // For simplicity, I'm setting the visibility to VISIBLE
        binding.card.visibility = View.VISIBLE
        isViewVisible = true
    }


}