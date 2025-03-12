package com.example.cacheit.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cacheit.data.ItemDatabase
import com.example.cacheit.data.Repository
import com.example.cacheit.domain.Item
import com.example.cacheit.domain.RetrofitInstance
import com.example.cacheit.domain.RetrofitInstance.apiService
import com.example.cacheit.domain.toDomainList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MyViewModel(application: Application) : ViewModel() {
    //CallBack Approach API Calling
    /*private val repository = Repository()
    val items: LiveData<List<Item>> = repository.fetchItems()*/

    private val itemDao = ItemDatabase.getDatabase(application)?.itemDao()
    private val apiService = RetrofitInstance.apiService

    private val _data = MutableLiveData<List<Item>>()
    val data: LiveData<List<Item>> get() = _data

    init {
        checkAndFetchData()
    }

    private fun checkAndFetchData() {
        viewModelScope.launch {
            val count = itemDao?.getItemCount()

            if(count == 0){
                fetchPosts()
                Log.e("DebuggingTracker","fetchPosts")
            }else{
                loadItemsFromDB()
                Log.e("DebuggingTracker","loadItemsFromDB")
            }
        }
    }

    private suspend fun loadItemsFromDB() {
        _data.value = itemDao?.getAllItems()?.toDomainList()
    }


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

    /*fun fetchPosts() {
        viewModelScope.launch {
            runCatching {
                apiService.getPosts().map { apiItem ->
                    com.example.cacheit.data.Item(
                        title = (apiItem.title?.toIntOrNull() ?: 0).toString(),
                        body = apiItem.body
                    ) } // Convert API response to DB Entity
            }.onSuccess { items ->
                itemDao?.insert(items)
                loadItemsFromDB()
            }.onFailure {
                Log.e("API_ERROR", "Failed to fetch items", it)
            }
        }
    }*/
}