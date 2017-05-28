package com.lev.modern_arch_2017.data.localDataSource.mapper

import com.lev.modern_arch_2017.data.localDataSource.entity.TaskEntity
import com.lev.modern_arch_2017.domain.entity.Task
import io.reactivex.functions.Function

/**
 * Author: Lev
 * Date: 28.05.2017
 */
class TaskMapper : Function<List<TaskEntity>, List<Task>> {

    override fun apply(entities: List<TaskEntity>): List<Task> {
        val tasks = mutableListOf<Task>()
        entities.forEach { tasks.add(map(it)) }
        return tasks
    }

    fun map(entity: TaskEntity) : Task {
        return Task(entity.id, entity.title ?: "", entity.description ?: "")
    }
}