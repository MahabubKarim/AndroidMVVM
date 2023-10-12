package com.example.androidapps2.repo.model

import com.example.androidapps2.core.remote.ResponseCallback

interface RepoListModel {
    fun getRepoList(callback: ResponseCallback<RepoResponse>)
}