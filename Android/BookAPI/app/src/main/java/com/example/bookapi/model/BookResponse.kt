package com.example.bookapi.model

data class BookResponse(
    val books: List<Book>,
    val error: String,
    val total: String
)