package com.example.mvvm.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val callAPI : RetrofitAPI by lazy{
         val retrofit = Retrofit.Builder()
             .baseUrl("https://open-api.xyz/placeholder/")
            // .baseUrl("https://email-address-verifier.p.rapidapi.com")
             .addConverterFactory(GsonConverterFactory.create())
             .build()
          retrofit.create(RetrofitAPI::class.java)

    }

}