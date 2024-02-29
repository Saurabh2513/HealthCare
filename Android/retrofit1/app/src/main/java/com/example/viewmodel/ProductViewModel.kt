package com.example.viewmodel

import ProductRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.Products
import com.example.retrofit1.network.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
class ProductViewModel(private  val repository: ProductRepository):ViewModel() {
    private  val product_m=MutableLiveData<NetworkResult<Products>>()
    val product:LiveData<NetworkResult<Products>>
        get() = product_m
    fun getProducts(){
        viewModelScope.launch(Dispatchers.IO) {
            val result=repository.getProduct()
            product_m.postValue(result)
        }
    }
}