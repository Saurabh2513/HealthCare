package com.example.task2nov.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.task2nov.databinding.ActivityMainBinding
import com.example.task2nov.view.adapter.UserAdapter
import com.example.task2nov.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userRecyclerView()

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        viewModel.getUserDetail()
        viewModel.observeUserLiveData().observe(this, Observer { userList ->
            userAdapter.setUserList(userList)
        })
    }



    private fun userRecyclerView() {
        userAdapter = UserAdapter()
        binding.recyclerview.apply {
            layoutManager = RecyclerView.LayoutManager(applicationContext, 2)
            adapter = userAdapter
        }
    }


}
