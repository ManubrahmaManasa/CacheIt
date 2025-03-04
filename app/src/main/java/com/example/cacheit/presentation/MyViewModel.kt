package com.example.cacheit.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cacheit.data.Repository
import com.example.cacheit.domain.Item
import com.example.cacheit.domain.RetrofitInstance.apiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    //CallBack Approach API Calling
    /*private val repository = Repository()
    val items: LiveData<List<Item>> = repository.fetchItems()*/
    private val _data = MutableLiveData<List<Item>>()
    val data: LiveData<List<Item>> get() = _data

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val response = apiService.getPosts()
                _data.value = response
            } catch (e: Exception) {
                _data.value = emptyList() // Handle failure
            }
        }
    }
}