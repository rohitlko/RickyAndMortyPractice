package com.example.rickyandmortypractice.api

import com.example.rickyandmortypractice.model.Data
import retrofit2.Call
import retrofit2.http.GET

//https://rickandmortyapi.com/api/character/


interface CharacterApi {

    @GET ("character/")
    fun getCharacters() : Call<Data>

}