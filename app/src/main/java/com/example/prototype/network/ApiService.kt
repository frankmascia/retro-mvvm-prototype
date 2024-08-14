package com.example.prototype.network

import com.example.prototype.model.Todo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


//Define the api service interface
interface ApiService {
    @GET("todos")
    suspend fun getTodo(): List<Todo>
}

//Create retrofit instance
object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/") //baseurl for the api
            .addConverterFactory(GsonConverterFactory.create()) //user Gson for JSON conversion
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}