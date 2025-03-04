package com.example.cacheit.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cacheit.domain.Item
import com.example.cacheit.domain.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//CallBack Approach API Calling
class Repository {
    private val apiService = RetrofitInstance.apiService

    /*fun fetchItems(): LiveData<List<Item>> {
        val data = MutableLiveData<List<Item>>()

        *//*apiService.getPosts().enqueue(object : Callback<List<Item>> {
            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                data.value = emptyList()
            }
        })
        return data*//*
    }*/
}