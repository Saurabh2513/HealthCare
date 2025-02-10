package com.example.bookapi.repo
import com.example.bookapi.api.BooksAPI
import com.example.bookapi.model.BookResponse
import com.example.bookapi.network.NetworkResult

class BookRepository(private val booksAPI: BooksAPI) {

    suspend fun getProduct(): NetworkResult<BookResponse> {
        val response=booksAPI.getProducts()
        return  if (response.isSuccessful){
            val responseBody=response.body()
            if (responseBody!= null){
                NetworkResult.Success(responseBody)
            }else{
                NetworkResult.Error("Something went wrong")
            }
        }else{
            NetworkResult.Error("Something went wrong")
        }
    }
}