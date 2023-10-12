package com.example.androidapps2.repo.model

import com.example.androidapps2.BuildConfig
import com.example.androidapps2.core.remote.ResponseCallback
import com.example.androidapps2.core.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class RepoListModelImpl : RepoListModel {
    private val repoApi = RetrofitClient.client.create<RepoApi>()

    override fun getRepoList(callback: ResponseCallback<RepoResponse>) {
        val callApi = repoApi.getRepoList("stars", BuildConfig.APPLICATION_ID)

        callApi.enqueue(object : Callback<RepoResponse> {
            override fun onResponse(
                call: Call<RepoResponse>,
                response: Response<RepoResponse>
            ) {
                val blogList = response.body()

                if(blogList == null) {
                    callback.onError("Data Not Available")
                } else {
                    callback.onSuccess(blogList!!)
                }
            }

            override fun onFailure(call: Call<RepoResponse>, t: Throwable) {
                callback.onError(t.message ?: "Find Something Wrong")
            }
        })
    }
}