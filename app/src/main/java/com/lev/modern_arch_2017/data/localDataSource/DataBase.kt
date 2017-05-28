package com.lev.modern_arch_2017.data.localDataSource

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.lev.modern_arch_2017.data.localDataSource.dao.TaskDao
import com.lev.modern_arch_2017.data.localDataSource.entity.TaskEntity

/**
 * Author: Lev
 * Date: 27.05.2017
 */
@Database(entities = arrayOf(TaskEntity::class), version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun TaskDao(): TaskDao
}