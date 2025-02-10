package com.example.bookapi.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapi.R
import com.example.bookapi.model.Book
import com.example.bookapi.myapp.MyApplication
import com.example.bookapi.network.NetworkResult
import com.example.bookapi.ui.adapters.BookAdapter
import com.example.bookapi.viewmodel.BookViewModel
import com.example.bookapi.viewmodel.BookViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var bookViewModel: BookViewModel
    private lateinit var recyclerView: RecyclerView
    var arrayList: ArrayList<Book> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvmain)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val repository = (application as MyApplication).productRepository

        bookViewModel = ViewModelProvider(this, BookViewModelFactory(repository)).get(
            BookViewModel::class.java
        )

        bookViewModel.getProducts()
        initObserver()
    }
    private fun initObserver() {
        bookViewModel.book.observe(this) {
            when (it) {
                is NetworkResult.Loading -> {
                }
                is NetworkResult.Success -> {
                    arrayList.addAll(it.data!!.books)
                    val bookAdapter = BookAdapter(this, arrayList)
                    recyclerView.adapter = bookAdapter
                    bookAdapter.setItemClickListener(object : BookAdapter.onItemClickListener {
                        override fun onItemClick(position: Int) {
                            // on click each item , what action do you perform
                            val intent = Intent(applicationContext, DetailActivity::class.java)
                            intent.putExtra("imageId",arrayList[position].image)
                            intent.putExtra("heading", arrayList[position].title)
                            intent.putExtra("description", arrayList[position].subtitle)
                            startActivity(intent)
                        }
                    })
                }

                is NetworkResult.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                }

                else -> {
                    Toast.makeText(this, "data Error", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}