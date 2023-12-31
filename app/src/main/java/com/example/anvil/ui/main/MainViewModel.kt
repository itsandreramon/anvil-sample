package com.example.anvil.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.anvil.data.RemoteDataSource
import timber.log.Timber
import javax.inject.Inject

class MainViewModel(
    private val remoteDataSource: RemoteDataSource
) : ViewModel() {

    init {
        Timber.d("Created main view model: $this")
    }

    fun getData(): String {
        return remoteDataSource.getData()
    }

    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        private val remoteDataSource: RemoteDataSource
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(remoteDataSource) as T
        }
    }
}