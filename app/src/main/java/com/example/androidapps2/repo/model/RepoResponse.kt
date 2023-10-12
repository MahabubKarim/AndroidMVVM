package com.example.androidapps2.repo.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RepoResponse(
    val items: List<Item>
) : Serializable {
    @Keep
    data class Item(
        @SerializedName("name")
        val name: String,
        @SerializedName("full_name")
        val fullName: String,
        @SerializedName("created_at")
        val createdDate: String,
        @SerializedName("description")
        val description: String?
    ) : Serializable
}