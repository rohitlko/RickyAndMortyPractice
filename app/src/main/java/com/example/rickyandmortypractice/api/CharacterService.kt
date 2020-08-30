package com.example.rickyandmortypractice.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://rickandmortyapi.com/api/"

object CharacterService {
    val characterInstance: CharacterApi
    val logging = HttpLoggingInterceptor()
    val client = OkHttpClient.Builder().addInterceptor(logging).build()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        characterInstance = retrofit.create(CharacterApi::class.java)
    }
}