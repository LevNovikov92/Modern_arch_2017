package com.lev.modern_arch_2017.presentation.view

import com.lev.modern_arch_2017.domain.entity.Task

/**
 * Author: Lev
 * Date: 17.05.2017
 */

interface TaskListView {

    fun showProgress()

    fun showZeroState()

    fun displayTasks(tasks: List<Task>)

}
