package com.example.anvil.di

import com.example.anvil.BuildConfig
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import timber.log.Timber

@Module
@ContributesTo(AppScope::class)
object AppModule {

    @Provides
    @IntoSet
    fun timberInitializer(): () -> Unit = {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}