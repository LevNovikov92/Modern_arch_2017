package com.lev.modern_arch_2017.DI.module

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors
import javax.inject.Named
import javax.inject.Singleton

/**
 * Author: Lev
 * Date: 17.05.2017
 */

@Module
class DomainModule {

    companion object {
        const val SCHEDULER_WORKER = "WorkerScheduler"
        const val SCHEDULER_UI = "UiScheduler"
    }

    @Singleton
    @Provides
    @Named(SCHEDULER_WORKER)
    internal fun provideWorkerScheduler(): Scheduler {
        return Schedulers.from(Executors.newFixedThreadPool(4))
    }

    @Singleton
    @Provides
    @Named(SCHEDULER_UI)
    internal fun provideUiScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}
