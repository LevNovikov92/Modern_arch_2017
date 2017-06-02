package com.lev.modern_arch_2017.DI.component

import com.lev.modern_arch_2017.DI.annotation.ActivityScope
import com.lev.modern_arch_2017.DI.module.ActivityModule
import com.lev.modern_arch_2017.DI.module.TaskListModule
import com.lev.modern_arch_2017.presentation.view.fragment.TaskListFragment
import dagger.Component

/**
 * Author: Lev
 * Date: 02.06.2017
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class, TaskListModule::class))
interface TaskListComponent : ActivityComponent {

    fun inject(fragment: TaskListFragment)
}
