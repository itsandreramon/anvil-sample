package com.example.anvil.session

import android.content.Context
import com.example.anvil.App
import com.example.anvil.di.AppScope
import com.example.anvil.di.SingleIn
import com.example.anvil.di.UserComponent
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

/**
 * Manages the lifecycle of the UserComponent by creating
 * it only when provided with a valid UserSession object.
 *
 * Modules included in the UserComponent and its descendents can safely
 * inject a UserSession object and will be recreated if a new UserSession
 * object is created.
 *
 * @property userComponent Stores dependencies scoped to a UserSession.
 */
interface UserSessionManager {

    val userComponent: UserComponent?

    fun resetSession()

    fun createSession(id: String)

    @SingleIn(AppScope::class)
    @ContributesBinding(AppScope::class)
    class Impl @Inject constructor(
        private val applicationContext: Context
    ) : UserSessionManager {

        override var userComponent: UserComponent? = null

        override fun resetSession() {
            userComponent = null
        }

        override fun createSession(id: String) {
            val app = applicationContext as App
            val session = UserSession(id)

            userComponent = app.appComponent
                .userComponentFactory()
                .create(session)
        }
    }
}