package com.example.rickyandmortypractice.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object CharacterService {
    val characterInstance: CharacterApi
    val logging = HttpLoggingInterceptor()
    val client = OkHttpClient.Builder().addInterceptor(logging).build()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        characterInstance = retrofit.create(CharacterApi::class.java)
    }

}