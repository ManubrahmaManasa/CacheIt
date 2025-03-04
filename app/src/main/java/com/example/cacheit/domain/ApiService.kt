package com.example.cacheit.domain

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    //CallBack Approach API Calling
    /*@GET("posts")
    fun getPosts(): Call<List<Item>>*/

    @GET("posts")
    suspend fun getPosts():List<Item>
}