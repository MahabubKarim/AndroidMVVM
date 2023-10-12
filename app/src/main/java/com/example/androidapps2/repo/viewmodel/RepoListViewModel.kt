package com.example.androidapps2.repo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidapps2.core.remote.ResponseCallback
import com.example.androidapps2.repo.model.RepoListModel
import com.example.androidapps2.repo.model.RepoListModelImpl
import com.example.androidapps2.repo.model.RepoResponse
import com.example.androidapps2.repo.model.RepoUiModel

class RepoListViewModel(private val model: RepoListModel) : ViewModel(){
    val showLoaderLiveData = MutableLiveData<Boolean>()
    val showErrorLiveData = MutableLiveData<String>()
    val blogListUiModelLiveData: MutableLiveData<List<RepoUiModel>> by lazy {
        MutableLiveData<List<RepoUiModel>>()
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val model: RepoListModel = RepoListModelImpl()
                return RepoListViewModel(model) as T
            }
        }
    }

    fun getRepoList() {
        showLoaderLiveData.postValue(true)

        model.getRepoList(object : ResponseCallback<RepoResponse> {
            override fun onSuccess(list: RepoResponse) {
                val blogUiModel = convertRepoResponseToRepoUiModel(list.items)
                showLoaderLiveData.postValue(false)
                blogListUiModelLiveData.postValue(blogUiModel)
            }

            override fun onError(error: String) {
                showLoaderLiveData.postValue(false)
                showErrorLiveData.postValue(error)
            }
        })
    }

    fun convertRepoResponseToRepoUiModel(blogResponseList: List<RepoResponse.Item>): List<RepoUiModel> {
        val repoUiModelList = mutableListOf<RepoUiModel>()

        blogResponseList.forEach {
            val repoUiModel = RepoUiModel(
                name = it.name,
                fullName = it.fullName,
                createdDate = it.createdDate,
                description = it.description ?: "Details Not Available"
            )
            repoUiModelList.add(repoUiModel)
        }

        return repoUiModelList
    }
}