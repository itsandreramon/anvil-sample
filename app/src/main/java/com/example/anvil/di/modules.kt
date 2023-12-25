package com.example.anvil.di

import android.content.Context
import com.example.anvil.App
import com.example.anvil.session.UserSessionManager
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope

@Module
@ContributesTo(AppScope::class)
object AppModule {

    @Provides
    @ApplicationCoroutineScope
    @SingleIn(AppScope::class)
    fun provideApplicationCoroutineScope(
        applicationContext: Context
    ): CoroutineScope {
        return (applicationContext as App).applicationScope
    }
}

@Module
@ContributesTo(UserScope::class)
object UserModule {

    @Provides
    @UserCoroutineScope
    @SingleIn(UserScope::class)
    fun provideUserCoroutineScope(
        userSessionManager: UserSessionManager,
    ): CoroutineScope {
        return userSessionManager.userCoroutineScope!!
    }
}