package com.lev.modern_arch_2017.data.localDataSource.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Author: Lev
 * Date: 27.05.2017
 */
@Entity(tableName = "task")
class TaskEntity {

    @PrimaryKey
    var id: Int = 0

    @ColumnInfo(name = "title")
    var title: String? = null

    @ColumnInfo(name = "description")
    var description: String? = null

}