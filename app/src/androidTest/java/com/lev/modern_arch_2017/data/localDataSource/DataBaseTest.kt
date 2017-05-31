package com.lev.modern_arch_2017.data.localDataSource

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.lev.modern_arch_2017.data.localDataSource.dao.TaskDao
import com.lev.modern_arch_2017.data.localDataSource.entity.TaskEntity
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Author: Lev
 * Date: 28.05.2017
 */
@RunWith(AndroidJUnit4::class)
class DataBaseTest {

    lateinit var db: DataBase
    lateinit var taskDao: TaskDao

    @Before
    fun before() {
        val context = InstrumentationRegistry.getContext()
        db = Room.inMemoryDatabaseBuilder(context, DataBase::class.java).build()
        taskDao = db.taskDao()
    }

    @After
    fun after() {
        db.close()
    }

    @Test
    fun taskDao() {
        val task = TaskEntity()
        task.id = 1
        task.title = "title"
        task.description = "desc"

        taskDao.insert(task)
        val subscriber = taskDao.findAll().test()

        subscriber.assertValueCount(1)
        val list = subscriber.values()[0]
        Assert.assertEquals(1, list.size)
        Assert.assertEquals(task.id, list[0].id)
        Assert.assertEquals(task.title, list[0].title)
        Assert.assertEquals(task.description, list[0].description)
    }

}