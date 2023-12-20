package com.sap.anvil

import android.app.Application
import com.sap.anvil.di.AppComponent
import com.sap.anvil.di.DaggerAppComponent
import com.sap.anvil.session.UserSessionManager
import javax.inject.Inject

class App : Application() {

    @Inject lateinit var userSessionManager: UserSessionManager

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