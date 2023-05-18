package com.example.noteukt.DataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes")
    fun getAllNotes():MutableList<DataModel>

    @Insert
    fun addNote(notes:DataModel)
}

