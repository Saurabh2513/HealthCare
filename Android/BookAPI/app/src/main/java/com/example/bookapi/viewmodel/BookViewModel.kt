package com.example.bookapi.viewmodel

import com.example.bookapi.repo.BookRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookapi.model.BookResponse
import com.example.bookapi.network.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(private val repository: BookRepository) : ViewModel() {
    private val book_m = MutableLiveData<NetworkResult<BookResponse>>()
    val book: LiveData<NetworkResult<BookResponse>>
        get() = book_m

    fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getProduct()
            book_m.postValue(result)
        }
    }
}