package com.example.rickyandmortypractice

// https://rickandmortyapi.com/documentation/#get-all-characters

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.rickyandmortypractice.api.CharacterService
import com.example.rickyandmortypractice.model.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getCharacters()
    }

    fun getCharacters() {
        val character = CharacterService.characterInstance.getCharacters()
        character.enqueue(object : Callback<Data> {
            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.e("Test", "Failed", t)
            }

            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                val character = response.body()
                if (character != null) {
                    Log.d("Test", character.toString())
                }
            }
        })
    }
}