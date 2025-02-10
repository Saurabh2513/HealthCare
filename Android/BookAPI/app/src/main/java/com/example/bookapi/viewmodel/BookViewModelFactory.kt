package com.example.bookapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bookapi.repo.BookRepository

@Suppress("UNCHECKED_CAST")
class BookViewModelFactory(private val bookRepository: BookRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BookViewModel(bookRepository) as T
    }
}