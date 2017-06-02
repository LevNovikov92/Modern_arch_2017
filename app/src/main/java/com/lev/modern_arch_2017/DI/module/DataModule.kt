package com.lev.modern_arch_2017.DI.module

import android.arch.persistence.room.Room
import android.content.Context
import com.lev.modern_arch_2017.data.TaskDataRepository
import com.lev.modern_arch_2017.data.TaskRepositoryImpl
import com.lev.modern_arch_2017.data.localDataSource.DataBase
import com.lev.modern_arch_2017.data.localDataSource.repository.LocalTaskDataRepository
import com.lev.modern_arch_2017.domain.TaskRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Author: Lev
 * Date: 02.06.2017
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideDataBase(context: Context): DataBase {
        return Room.databaseBuilder(context, DataBase::class.java, "database.db").build()
    }

    @Provides
    @Singleton
    fun provideTaskRepository(localRepository: TaskDataRepository): TaskRepository {
        return TaskRepositoryImpl(localRepository)
    }

    @Provides
    @Singleton
    fun provideTaskDataRepository(localTaskDataRepository: LocalTaskDataRepository): TaskDataRepository {
        return localTaskDataRepository
    }
}
