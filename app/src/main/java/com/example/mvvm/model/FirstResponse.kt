package com.example.mvvm.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class FirstResponse {
    @SerializedName("pk")
    val pk: Int? = null

    @SerializedName("title")
    val title: String? = null

    @SerializedName("image")
    val image: String? = null

    @SerializedName("body")
    val body: String? = null

    @SerializedName("category")
    val category: String? = null

}