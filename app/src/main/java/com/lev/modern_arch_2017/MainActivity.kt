package com.lev.modern_arch_2017

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.lev.modern_arch_2017.DI.AppComponent
import com.lev.modern_arch_2017.domain.TaskRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var taskRepository: TaskRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getAppComponent().inject(this)
        taskRepository.getTasks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    tasks -> tasks.forEach { Log.i("!LOG", "${it.title} ${it.description}") }
                }, { error -> error.printStackTrace() })
    }

    private fun getAppComponent(): AppComponent {
        return (application as App).getComponent()
    }
}
