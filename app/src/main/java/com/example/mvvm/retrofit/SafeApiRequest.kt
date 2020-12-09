package com.example.mvvm.retrofit

import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.io.IOException

abstract class SafeApiRequest {

    suspend fun<T: Any> apiRequest(call: suspend () -> Response<T>) : T{
        val response = call.invoke()
        System.out.println("======SafeApiRequest=====")
        if(response.isSuccessful){
            System.out.println("Expected Response ==="+response.body() + response.isSuccessful)
            return response.body()!!
        }else{
            val error = response.errorBody()?.toString()
                val message = StringBuilder()
            error?.let{
                try{
                    System.out.println("Error Response===")
                    message.append(JSONObject(it).getString("message"))
                }catch(e: JSONException){ }
                message.append("\n")
                message.append("Error Code: ${response.code()}")
            }
          //  throw IOException(message.toString())
            return error.toString() as T
        }
    }

}