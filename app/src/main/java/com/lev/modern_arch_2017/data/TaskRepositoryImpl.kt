package com.lev.modern_arch_2017.data

import com.lev.modern_arch_2017.data.localDataSource.mapper.TaskMapper
import com.lev.modern_arch_2017.domain.TaskRepository
import com.lev.modern_arch_2017.domain.entity.Task
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Author: Lev
 * Date: 27.05.2017
 */
class TaskRepositoryImpl @Inject constructor(var taskDataRepository: TaskDataRepository) : TaskRepository {

    override fun getTasks(): Flowable<List<Task>> {
        return taskDataRepository.findAll().map(TaskMapper())
    }
}