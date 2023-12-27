package com.example.anvil.di

import com.example.anvil.App
import com.example.anvil.AppCoroutineScope
import com.example.anvil.session.UserCoroutineScope
import com.example.anvil.session.UserSession
import com.example.anvil.ui.login.LoginActivity
import com.example.anvil.ui.main.MainActivity
import com.squareup.anvil.annotations.MergeComponent
import com.squareup.anvil.annotations.MergeSubcomponent
import com.squareup.anvil.annotations.optional.SingleIn
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance app: App,
            @BindsInstance appCoroutineScope: AppCoroutineScope,
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
            @BindsInstance userSession: UserSession,
            @BindsInstance userCoroutineScope: UserCoroutineScope,
        ): UserComponent
    }

    fun inject(activity: MainActivity)
}