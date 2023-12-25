package com.example.anvil

import android.app.Application
import com.example.anvil.di.AppComponent
import com.example.anvil.di.DaggerAppComponent
import com.example.anvil.session.UserSessionManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject

class App : Application() {

    @Inject lateinit var userSessionManager: UserSessionManager

    val applicationScope = CoroutineScope(SupervisorJob())

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .factory()
            .create(this)
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}