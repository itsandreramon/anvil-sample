package com.example.anvil.data

import com.example.anvil.di.AppScope
import com.example.anvil.di.ApplicationCoroutineScope
import com.example.anvil.di.SingleIn
import com.example.anvil.util.log
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

@SingleIn(AppScope::class)
class LocalDataSource @Inject constructor(
    @ApplicationCoroutineScope coroutineScope: CoroutineScope
) : DataSource {

    init {
        log("Creating data source: $this")
        log("Got coroutine scope: $coroutineScope")
    }

    override fun getData(): String {
        return "No user session found"
    }
}