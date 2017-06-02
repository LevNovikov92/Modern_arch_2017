package com.lev.modern_arch_2017.DI.module

import android.app.Activity
import com.lev.modern_arch_2017.DI.annotation.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Author: Lev
 * Date: 02.06.2017
 */

@Module
class ActivityModule(private val mActivity: Activity) {

    @Provides
    @ActivityScope
    fun provideActivity(): Activity {
        return mActivity
    }
}
