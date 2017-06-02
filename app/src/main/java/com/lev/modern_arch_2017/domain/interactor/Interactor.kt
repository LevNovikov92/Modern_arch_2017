package com.lev.modern_arch_2017.domain.interactor

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

/**
 * Author: Lev
 * Date: 02.06.2017
 */
abstract class Interactor<Result, Params>(workerScheduler: Scheduler, uiScheduler: Scheduler) {

    private val mWorkerScheduler = workerScheduler
    private val mUiScheduler = uiScheduler
    private val mCompositeDisposable = CompositeDisposable()

    abstract fun performUseCase(params: Params?): Observable<Result>

    fun execute(observer: DisposableObserver<Result>, params: Params?) {
        val observable = performUseCase(params)
                .subscribeOn(mWorkerScheduler)
                .observeOn(mUiScheduler)
        addDisposable(observable.subscribeWith<DisposableObserver<Result>>(observer))
    }

    private fun addDisposable(observer: Disposable) {
        mCompositeDisposable.add(observer)
    }

    fun disposeAll() {
        mCompositeDisposable.dispose()
    }
}