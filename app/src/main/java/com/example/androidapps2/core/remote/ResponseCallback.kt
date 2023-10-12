package com.example.androidapps2.core.remote

interface ResponseCallback<T> {
    fun onSuccess(list: T)
    fun onError(error: String)
}