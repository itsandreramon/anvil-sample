package com.example.anvil.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.anvil.data.DataSource
import com.example.anvil.util.log
import javax.inject.Inject

class MainViewModel(
    private val remoteDataSource: DataSource.RemoteDataSource
) : ViewModel() {

    init {
        log("Created main view model: $this")
    }

    fun getData(): String {
        return remoteDataSource.getData()
    }

    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        private val remoteDataSource: DataSource.RemoteDataSource
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(remoteDataSource) as T
        }
    }
}