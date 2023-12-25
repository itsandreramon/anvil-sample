package com.example.anvil.data

import com.example.anvil.di.SingleIn
import com.example.anvil.di.UserCoroutineScope
import com.example.anvil.di.UserScope
import com.example.anvil.session.UserSession
import com.example.anvil.util.log
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

@SingleIn(UserScope::class)
class RemoteDataSource @Inject constructor(
    private val userSession: UserSession,
    @UserCoroutineScope coroutineScope: CoroutineScope,
) : DataSource {

    init {
        log("Creating data source: $this")
        log("Got coroutine scope: $coroutineScope")
    }

    override fun getData(): String {
        return "Some data for user ${userSession.id}"
    }
}