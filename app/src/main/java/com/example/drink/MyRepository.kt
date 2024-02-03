package com.example.drink

import com.example.drink.model.Data
import com.example.drink.retrofit.ApiService
import retrofit2.Response

class MyRepository (private val apiService: ApiService) {
    suspend fun fetchData(s: String): Response<Data> {
        return apiService.getData(s)
    }

//    suspend fun getUserDetail(userId: Int): Response<User> {
//        return apiService.getUserDetail(userId)
//    }
}