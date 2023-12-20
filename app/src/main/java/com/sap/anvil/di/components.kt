package com.sap.anvil.di

import android.content.Context
import com.sap.anvil.App
import com.sap.anvil.session.UserSession
import com.sap.anvil.ui.LoginActivity
import com.sap.anvil.ui.MainActivity
import com.squareup.anvil.annotations.ContributesSubcomponent
import com.squareup.anvil.annotations.ContributesTo
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