package com.example.anvil.session

import com.example.anvil.App
import com.example.anvil.di.AppScope
import com.example.anvil.di.UserComponent
import com.squareup.anvil.annotations.ContributesBinding
import com.squareup.anvil.annotations.optional.SingleIn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import timber.log.Timber
import javax.inject.Inject

class UserCoroutineScope(
    private val parentScope: CoroutineScope
) : CoroutineScope by parentScope

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
        private val app: App,
    ) : UserSessionManager {

        private var _userCoroutineScope: UserCoroutineScope? = null

        private val userCoroutineScope: UserCoroutineScope
            get() = _userCoroutineScope ?: createUserCoroutineScope()

        override var userComponent: UserComponent? = null
            private set

        override fun resetSession() {
            Timber.d("reset session...")
            _userCoroutineScope?.cancel()
            _userCoroutineScope = null
            userComponent = null
        }

        override fun createSession(id: String) {
            Timber.d("create session...")
            val session = UserSession(id)

            userComponent = app.appComponent
                .userComponentFactory()
                .create(session, userCoroutineScope)
        }

        private fun createUserCoroutineScope(): UserCoroutineScope {
            return _userCoroutineScope ?: UserCoroutineScope(
                CoroutineScope(SupervisorJob())
            ).also { _userCoroutineScope = it }
        }
    }
}