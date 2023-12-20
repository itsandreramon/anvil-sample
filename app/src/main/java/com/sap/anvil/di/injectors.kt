package com.sap.anvil.di

import com.sap.anvil.App
import com.sap.anvil.ui.LoginActivity
import com.sap.anvil.ui.MainActivity

fun inject(activity: MainActivity) {
    (activity.applicationContext as App)
        .userSessionManager
        .userComponent!!
        .inject(activity)
}

fun inject(activity: LoginActivity) {
    (activity.applicationContext as App)
        .appComponent
        .inject(activity)
}