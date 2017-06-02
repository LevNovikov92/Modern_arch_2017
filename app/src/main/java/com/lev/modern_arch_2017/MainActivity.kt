package com.lev.modern_arch_2017

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.lev.modern_arch_2017.DI.component.DaggerTaskListComponent
import com.lev.modern_arch_2017.DI.component.TaskListComponent
import com.lev.modern_arch_2017.DI.module.ActivityModule
import com.lev.modern_arch_2017.presentation.view.fragment.TaskListFragment

class MainActivity : AppCompatActivity() {

    lateinit var mComponent: TaskListComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        initializeInjection()
        showFragment(TaskListFragment())
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit()
    }

    internal fun initializeInjection() {
        mComponent = DaggerTaskListComponent.builder()
                .appComponent((application as App).getComponent())
                .activityModule(ActivityModule(this))
                .build()
    }

    fun getComponent(): TaskListComponent {
        return mComponent
    }
}
