package com.example.anvil

import android.app.Application
import com.example.anvil.di.AppComponent
import com.example.anvil.di.DaggerAppComponent
import com.example.anvil.di.DaggerSet
import com.example.anvil.di.InitializerFunction
import com.example.anvil.session.UserSessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject

class AppCoroutineScope(
    private val parentScope: CoroutineScope
) : CoroutineScope by parentScope

class App : Application() {

    @Inject lateinit var userSessionManager: UserSessionManager
    @Inject lateinit var appInitializers: DaggerSet<InitializerFunction>

    private val appCoroutineScope: AppCoroutineScope by lazy {
        AppCoroutineScope(CoroutineScope(SupervisorJob()))
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .factory()
            .create(this, appCoroutineScope)
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        appInitializers.forEach { it() }
    }
}