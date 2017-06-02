package com.lev.modern_arch_2017.presentation.presenter

import android.arch.lifecycle.ViewModel
import com.lev.modern_arch_2017.domain.entity.Task
import com.lev.modern_arch_2017.domain.interactor.TaskListInteractor
import com.lev.modern_arch_2017.presentation.view.TaskListView
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

/**
 * Author: Lev
 * Date: 02.06.2017
 */
class TaskListPresenter @Inject constructor(
        taskListInteractor: TaskListInteractor,
        view: TaskListView) : ViewModel(), Presenter {

    private val mTaskListInteractor = taskListInteractor
    private val mView = view

    fun loadTasks() {
        mTaskListInteractor.execute(object : DisposableObserver<List<Task>>(){
            override fun onComplete() {}

            override fun onNext(tasks: List<Task>) {
                mView
            }

            override fun onError(e: Throwable) {
                TODO("not implemented")
            }

        }, null)
    }

    override fun onResume() {}

    override fun onPause() {}

    override fun onDestroy() {}

    fun  onItemClick(id: Int) {}
}