package com.chirikualii.materiapi.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chirikualii.materiapi.data.remote.ApiClient
import com.chirikualii.materiapi.data.repository.MovieRepoImpl

class MainViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = MainViewModel(
            MovieRepoImpl(ApiClient.service)
        ) as T
        return viewModel
    }
}