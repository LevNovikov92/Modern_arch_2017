package com.lev.modern_arch_2017

import android.app.Application
import com.lev.modern_arch_2017.DI.component.AppComponent
import com.lev.modern_arch_2017.DI.component.DaggerAppComponent
import com.lev.modern_arch_2017.DI.module.AppModule

/**
 * Author: Lev
 * Date: 27.05.2017
 */
class App : Application() {

    lateinit var  mComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initializeComponent()
    }

    private fun initializeComponent() {
        mComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    fun getComponent(): AppComponent {
        return mComponent
    }
}