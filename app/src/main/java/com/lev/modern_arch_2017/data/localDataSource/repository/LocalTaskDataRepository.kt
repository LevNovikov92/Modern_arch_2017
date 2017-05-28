package com.lev.modern_arch_2017.data.localDataSource.repository

import com.lev.modern_arch_2017.data.TaskDataRepository
import com.lev.modern_arch_2017.data.localDataSource.DataBase
import com.lev.modern_arch_2017.data.localDataSource.entity.TaskEntity
import io.reactivex.Flowable
import javax.inject.Inject
/**
 * Author: Lev
 * Date: 27.05.2017
 */
class LocalTaskDataRepository @Inject constructor(val dataBase: DataBase) : TaskDataRepository {

    override fun findAll(): Flowable<List<TaskEntity>> {
        return dataBase.TaskDao().findAll()
    }
}