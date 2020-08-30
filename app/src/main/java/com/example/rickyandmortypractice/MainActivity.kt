package com.example.rickyandmortypractice

// https://rickandmortyapi.com/documentation/#get-all-characters

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickyandmortypractice.Adapter.CharacterAdapter
import com.example.rickyandmortypractice.api.CharacterService
import com.example.rickyandmortypractice.model.Character
import com.example.rickyandmortypractice.model.Data
import kotlinx.android.synthetic.main.activity_main.characterListRecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


val dataList = ArrayList<Character>()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        characterListRecyclerView.layoutManager = LinearLayoutManager(this)
        characterListRecyclerView.adapter = CharacterAdapter(dataList)
        getCharacters()
    }

    fun getCharacters() {
        val character = CharacterService.characterInstance.getCharacters()
        character.enqueue(object : Callback<Data> {
            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.e("Test", "Failed", t)
            }

            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                val characterdata = response?.body()
                if (characterdata != null) {
                    dataList.addAll(characterdata?.results)
                    characterListRecyclerView.adapter?.notifyDataSetChanged()

                    Log.i("Test", response?.body().toString())
                }
            }
        })
    }

}