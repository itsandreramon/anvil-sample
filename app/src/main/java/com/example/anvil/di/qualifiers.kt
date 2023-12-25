package com.example.anvil.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationCoroutineScope

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class UserCoroutineScope