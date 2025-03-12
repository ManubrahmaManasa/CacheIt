package com.example.cacheit.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cacheit.domain.Item
import com.example.cacheit.domain.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//CallBack Approach API Calling
class Repository(private val context: Context,private val itemDao: ItemDao) {

    private val contextForRepo = context.applicationContext
    private var allItems:List<com.example.cacheit.data.Item> = emptyList()

    //fetchandInsertAll
    suspend fun fetchAndInsertAll() = withContext(Dispatchers.IO){
        val allItems = getAllItems()
        if(allItems.isNotEmpty()){
            return@withContext
        }else{
            //fetch it from api
        }
    }


    //getAllItems

    suspend fun getAllItems():List<com.example.cacheit.data.Item> = withContext(Dispatchers.IO){
        if(allItems.isNotEmpty()){
            return@withContext allItems
        }else{
            //allItems = itemDao.getAllItems()
            return@withContext allItems
        }
    }







    //private val apiService = RetrofitInstance.apiService
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