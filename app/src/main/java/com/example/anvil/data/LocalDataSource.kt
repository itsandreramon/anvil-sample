package com.example.anvil.data

import com.example.anvil.AppCoroutineScope
import com.example.anvil.di.AppScope
import com.example.anvil.di.SingleIn
import com.example.anvil.util.log
import javax.inject.Inject

@SingleIn(AppScope::class)
class LocalDataSource @Inject constructor(
    coroutineScope: AppCoroutineScope,
) : DataSource {

    init {
        log("Creating data source: $this")
        log("Got coroutine scope: $coroutineScope")
    }

    override fun getData(): String {
        return "No user session found"
    }
}