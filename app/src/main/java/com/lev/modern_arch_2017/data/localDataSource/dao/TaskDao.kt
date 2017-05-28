package com.lev.modern_arch_2017.data.localDataSource.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.lev.modern_arch_2017.data.localDataSource.entity.TaskEntity
import io.reactivex.Flowable

/**
 * Author: Lev
 * Date: 27.05.2017
 */
@Dao
interface TaskDao {
    @Query("SELECT * FROM `task`")
    fun findAll(): Flowable<List<TaskEntity>>
}