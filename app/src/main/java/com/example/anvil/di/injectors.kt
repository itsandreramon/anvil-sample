package com.example.anvil.di

import com.example.anvil.App
import com.example.anvil.ui.login.LoginActivity
import com.example.anvil.ui.main.MainActivity

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