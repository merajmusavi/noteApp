package com.example.noteukt.DataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class DataModel(

    @PrimaryKey
    val id: Int,

    @ColumnInfo
    val title: String,

    @ColumnInfo
    val description: String
)

