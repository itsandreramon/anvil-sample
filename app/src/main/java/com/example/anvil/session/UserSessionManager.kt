package com.example.anvil.session

import android.content.Context
import com.example.anvil.App
import com.example.anvil.di.AppScope
import com.example.anvil.di.SingleIn
import com.example.anvil.di.UserComponent
import com.example.anvil.util.log
import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
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

    val userCoroutineScope: CoroutineScope?

    val userComponent: UserComponent?

    fun resetSession()

    fun createSession(id: String)

    @SingleIn(AppScope::class)
    @ContributesBinding(AppScope::class)
    class Impl @Inject constructor(
        private val applicationContext: Context
    ) : UserSessionManager {

        override var userCoroutineScope: CoroutineScope? = null

        override var userComponent: UserComponent? = null

        override fun resetSession() {
            log("reset session...")
            userCoroutineScope?.cancel()
            userComponent = null
        }

        override fun createSession(id: String) {
            log("create session...")
            val app = applicationContext as App
            val session = UserSession(id)

            userCoroutineScope = CoroutineScope(SupervisorJob())
            userComponent = app.appComponent
                .userComponentFactory()
                .create(session)
        }
    }
}