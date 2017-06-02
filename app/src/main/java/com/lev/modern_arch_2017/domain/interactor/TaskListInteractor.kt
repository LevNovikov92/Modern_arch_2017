package com.lev.modern_arch_2017.domain.interactor

import com.lev.modern_arch_2017.DI.module.DomainModule
import com.lev.modern_arch_2017.domain.TaskRepository
import com.lev.modern_arch_2017.domain.entity.Task
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

/**
 * Author: Lev
 * Date: 02.06.2017
 */
class TaskListInteractor @Inject constructor(
        taskRepository: TaskRepository,
        @Named(DomainModule.SCHEDULER_WORKER) workerScheduler: Scheduler,
        @Named(DomainModule.SCHEDULER_UI) uiScheduler: Scheduler) :
        Interactor<List<Task>, Void>(workerScheduler, uiScheduler) {

    private val mTaskRepository = taskRepository

    override fun performUseCase(params: Void?): Observable<List<Task>> {
        return mTaskRepository.getTasks().toObservable()
    }
}