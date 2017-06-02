package com.lev.modern_arch_2017.DI.component

import android.app.Activity

import com.lev.modern_arch_2017.DI.annotation.ActivityScope
import com.lev.modern_arch_2017.DI.module.ActivityModule

import dagger.Component

/**
 * Author: Lev
 * Date: 02.06.2017
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun activity(): Activity
}
