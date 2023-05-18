package com.example.noteukt.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [DataModel::class], version = 1)
abstract class DataBase() : RoomDatabase {
abstract fun getNotes():NotesDao

fun createDataBase(context:Context){
    Room.databaseBuilder(context.applicationContext,DataBase::class.java,"noteDb.db")
        .allowMainThreadQueries()
        .build()
}
}