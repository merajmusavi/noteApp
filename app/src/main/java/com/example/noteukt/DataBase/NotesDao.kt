package com.example.noteukt.DataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDao {

    @Query("SELECT * FROM notes")
    fun getAllNotes():MutableList<DataModel>

    @Insert
    fun addNote(notes:DataModel)

    @Query("DELETE FROM notes WHERE id = :itemId")
     fun deleteItemById(itemId: Long)

     @Query("SELECT * FROM notes WHERE id = :itemId")
     fun selectById(itemId: Long)

    @Update
    fun updateTask(task:DataModel)


}

