package com.lev.modern_arch_2017.presentation.view.fragment

import android.support.v4.app.Fragment
import com.lev.modern_arch_2017.presentation.presenter.Presenter

/**
 * Author: Lev
 * Date: 18.05.2017
 */

abstract class BaseFragment : Fragment() {

    internal abstract fun basePresenter(): Presenter

    override fun onResume() {
        super.onResume()
        basePresenter().onResume()
    }

    override fun onPause() {
        super.onPause()
        basePresenter().onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        basePresenter().onDestroy()
    }
}
