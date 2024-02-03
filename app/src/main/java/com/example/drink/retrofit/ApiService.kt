package com.example.drink.retrofit

import com.example.drink.model.Data
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search.php?")
    suspend fun getData(
        @Query("s") limit: String,
    ): Response<Data>
}