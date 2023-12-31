@file:Suppress("unused")

package com.example.anvil.di

typealias DaggerSet<T> = @JvmSuppressWildcards Set<T>

typealias DaggerMap<K, V> = @JvmSuppressWildcards Map<K,V>

typealias InitializerFunction = () -> @JvmSuppressWildcards Unit