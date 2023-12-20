package com.example.anvil.data

import com.example.anvil.session.UserSession
import com.example.anvil.util.log
import javax.inject.Inject

interface DataSource {

    fun getData(): String

    class LocalDataSource @Inject constructor() : DataSource {

        init {
            log("Creating data source: $this")
        }

        override fun getData(): String {
            return "No user session found"
        }
    }

    class RemoteDataSource @Inject constructor(
        private val userSession: UserSession
    ) : DataSource {

        init {
            log("Creating data source: $this")
        }

        override fun getData(): String {
            return "Some data for user ${userSession.id}"
        }
    }
}