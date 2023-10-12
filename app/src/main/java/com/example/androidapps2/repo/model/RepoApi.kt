package com.example.androidapps2.repo.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RepoApi {
    @GET("repositories?q=android")
    fun getRepoList(
        @Query("sort") sortParam: String,
        @Header("X-Application-ID") applicationId: String
    ): Call<RepoResponse>
}