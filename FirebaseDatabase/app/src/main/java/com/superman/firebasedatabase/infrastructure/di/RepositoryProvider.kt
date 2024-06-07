package com.superman.firebasedatabase.infrastructure.di

import com.superman.firebasedatabase.database.FirebaseRepository
import com.superman.firebasedatabase.database.IRepository
import com.superman.firebasedatabase.database.IRootRepository
import com.superman.firebasedatabase.database.domain.Department
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryProvider {
    @Provides
    @Singleton
    fun AddDepartmentFirebaseRepository(): IRootRepository = FirebaseRepository<Department>("Departments");
    
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DepartmentFirebaseRepository