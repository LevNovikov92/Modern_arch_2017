package com.lev.modern_arch_2017.DI

import android.content.Context
import com.lev.modern_arch_2017.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Author: Lev
 * Date: 27.05.2017
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context(): Context

    fun inject(mainActivity: MainActivity)
}