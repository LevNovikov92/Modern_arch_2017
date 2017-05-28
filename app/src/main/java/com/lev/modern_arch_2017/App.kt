package com.lev.modern_arch_2017

import android.app.Application
import com.lev.modern_arch_2017.DI.AppComponent
import com.lev.modern_arch_2017.DI.AppModule
import com.lev.modern_arch_2017.DI.DaggerAppComponent

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