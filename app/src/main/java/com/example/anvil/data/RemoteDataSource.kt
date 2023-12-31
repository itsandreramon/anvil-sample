package com.example.anvil.data

import com.example.anvil.di.UserScope
import com.example.anvil.session.UserCoroutineScope
import com.example.anvil.session.UserSession
import com.squareup.anvil.annotations.optional.SingleIn
import timber.log.Timber
import javax.inject.Inject

@SingleIn(UserScope::class)
class RemoteDataSource @Inject constructor(
    private val userSession: UserSession,
    coroutineScope: UserCoroutineScope,
) : DataSource {

    init {
        Timber.d("Creating data source: $this")
        Timber.d("Got coroutine scope: $coroutineScope")
    }

    override fun getData(): String {
        return "Some data for user ${userSession.id}"
    }
}