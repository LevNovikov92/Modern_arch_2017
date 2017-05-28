package com.lev.modern_arch_2017.domain

import com.lev.modern_arch_2017.domain.entity.Task
import io.reactivex.Flowable

/**
 * Author: Lev
 * Date: 27.05.2017
 */
interface TaskRepository {
    fun getTasks(): Flowable<List<Task>>
}