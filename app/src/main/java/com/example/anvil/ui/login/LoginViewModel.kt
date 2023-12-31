package com.example.anvil.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.anvil.data.LocalDataSource
import timber.log.Timber
import javax.inject.Inject

class LoginViewModel(
    private val localDataSource: LocalDataSource,
) : ViewModel() {

    init {
        Timber.d("Created login view model: $this")
    }

    fun getData(): String {
        return localDataSource.getData()
    }

    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        private val localDataSource: LocalDataSource,
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginViewModel(localDataSource) as T
        }
    }
}