package com.superman.firebasedatabase.infrastructure.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CoroutineProvider {


    @Provides
    @Singleton
    @CoroutineIO
    public fun AddCoroutineIO(): CoroutineScope = CoroutineScope(Dispatchers.IO)

    @Provides
    @Singleton
    @CoroutineDefault
    public fun AddCoroutineDefault(): CoroutineScope = CoroutineScope(Dispatchers.Default)

    @Provides
    @Singleton
    @CoroutineMain
    public fun AddCoroutineMain(): CoroutineScope = CoroutineScope(Dispatchers.Main)


}


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class CoroutineIO

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class CoroutineDefault

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class CoroutineMain

