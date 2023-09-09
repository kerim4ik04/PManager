package com.example.pmanager.data.local.db

import androidx.room.*
import com.example.pmanager.model.Task

@Dao
interface TaskDao {

    @Insert
    fun insert(task: Task)

    @Query("SELECT * FROM task ORDER BY id DESC")
    fun getAll(): List<Task>

    @Delete
    fun delete(task: Task)

    @Update
    fun update(task: Task)
}