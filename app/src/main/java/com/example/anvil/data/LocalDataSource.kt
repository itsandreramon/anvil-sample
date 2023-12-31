package com.example.anvil.data

import com.example.anvil.AppCoroutineScope
import com.example.anvil.di.AppScope
import com.squareup.anvil.annotations.optional.SingleIn
import timber.log.Timber
import javax.inject.Inject

@SingleIn(AppScope::class)
class LocalDataSource @Inject constructor(
    coroutineScope: AppCoroutineScope,
) : DataSource {

    init {
        Timber.d("Creating data source: $this")
        Timber.d("Got coroutine scope: $coroutineScope")
    }

    override fun getData(): String {
        return "No user session found"
    }
}