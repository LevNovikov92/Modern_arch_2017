package com.lev.modern_arch_2017.data

import com.lev.modern_arch_2017.data.localDataSource.entity.TaskEntity
import io.reactivex.Flowable

/**
 * Author: Lev
 * Date: 28.05.2017
 */
interface TaskDataRepository {

    fun findAll(): Flowable<List<TaskEntity>>
}