package com.example.androidapps2.repo.model

import java.io.Serializable

data class RepoUiModel(
    val name: String,
    val fullName: String,
    val createdDate:String,
    val description: String
) : Serializable