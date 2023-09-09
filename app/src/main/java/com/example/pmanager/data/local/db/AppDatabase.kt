package com.example.pmanager.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pmanager.model.Task


@Database(entities = [Task::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}