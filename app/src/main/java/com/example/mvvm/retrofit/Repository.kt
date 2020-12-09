package com.example.mvvm.retrofit

import com.example.mvvm.model.FirstResponse

class Repository : SafeApiRequest() {

   suspend fun resp() : List<FirstResponse> {
       System.out.println("======Repository=====")
       val response = apiRequest{RetrofitInstance.callAPI.getphotos()};
       return response
    }

   /* suspend fun loginresonse(str : String) : List<FirstResponse> {
        System.out.println("======Repository=====")
        var map = HashMap<String, Any>()
        map.put("Name","Ravi")
        val response = apiRequest{RetrofitInstance.callAPI.getphoto(map)};
        return response
    }*/


}