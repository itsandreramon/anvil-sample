package com.example.anvil.di

import com.example.anvil.data.DataSource
import com.example.anvil.session.UserSession
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides

@Module
@ContributesTo(AppScope::class)
object AppModule {

    @Provides
    @SingleIn(AppScope::class)
    fun provideDataSource(): DataSource.LocalDataSource {
        return DataSource.LocalDataSource()
    }
}

@Module
@ContributesTo(UserScope::class)
object UserModule {

    @Provides
    @SingleIn(UserScope::class)
    fun provideDataSource(
        userSession: UserSession,
    ): DataSource.RemoteDataSource {
        return DataSource.RemoteDataSource(userSession)
    }
}