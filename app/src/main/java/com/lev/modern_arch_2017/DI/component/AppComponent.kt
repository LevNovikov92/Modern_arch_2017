package com.lev.modern_arch_2017.DI.component

import android.content.Context
import com.lev.modern_arch_2017.DI.module.AppModule
import com.lev.modern_arch_2017.DI.module.DataModule
import com.lev.modern_arch_2017.DI.module.DomainModule
import com.lev.modern_arch_2017.MainActivity
import com.lev.modern_arch_2017.domain.TaskRepository
import dagger.Component
import io.reactivex.Scheduler
import javax.inject.Named
import javax.inject.Singleton

/**
 * Author: Lev
 * Date: 27.05.2017
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class, DomainModule::class))
interface AppComponent {
    fun context(): Context

    fun taskRepository(): TaskRepository

    @Named(DomainModule.SCHEDULER_WORKER) fun workerScheduler(): Scheduler

    @Named(DomainModule.SCHEDULER_UI) fun uiScheduler(): Scheduler

    fun inject(mainActivity: MainActivity)
}