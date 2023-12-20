package com.example.anvil.di

import android.content.Context
import com.example.anvil.App
import com.example.anvil.session.UserSession
import com.example.anvil.ui.LoginActivity
import com.example.anvil.ui.MainActivity
import com.squareup.anvil.annotations.MergeComponent
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance applicationContext: Context
        ): AppComponent
    }

    fun userComponentFactory(): UserComponent.Factory

    fun inject(app: App)

    fun inject(loginActivity: LoginActivity)
}

@SingleIn(UserScope::class)
@MergeSubcomponent(UserScope::class)
interface UserComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance userSession: UserSession
        ): UserComponent
    }

    fun inject(activity: MainActivity)
}