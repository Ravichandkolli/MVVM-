package com.example.mvvm.retrofit

import android.provider.ContactsContract
import com.example.mvvm.model.FirstResponse
import retrofit2.Response
import retrofit2.http.*

interface RetrofitAPI {

    @GET("blogs")
    suspend fun  getphotos() : Response<List<FirstResponse>>

    @GET("blog")
    suspend fun  getphoto(map: HashMap<String, Any>) : Response<List<FirstResponse>>



    @POST("verify")
    @Headers("content-type: application/json",
        "x-rapidapi-key: 2e1873848bmsh56c5477e7df8bc4p11b3afjsnd2642e66144b",
        "x-rapidapi-host: email-address-verifier.p.rapidapi.com",
        "useQueryString: true"
    )
    @FormUrlEncoded
    suspend fun verifyEmail(@Field("email") email: String) : Response<Any>



   /*companion object{
      operator fun invoke() : RetrofitAPI{
          return  Retrofit.Builder()
              .baseUrl("https://open-api.xyz/placeholder/")
              .addConverterFactory(GsonConverterFactory.create())
              .build()
              .create(RetrofitAPI :: class.java)
      }
   }*/
}