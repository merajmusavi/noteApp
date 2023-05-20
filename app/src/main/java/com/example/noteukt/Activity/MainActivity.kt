package com.example.noteukt.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteukt.DataBase.DataModel
import com.example.noteukt.R
import com.example.noteukt.Adapter.RecyclerAdapter
import com.example.noteukt.DataBase.DataBase
import com.example.noteukt.DataBase.NotesDao
import com.example.noteukt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var notesDao:NotesDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notesDao = DataBase.createDataBase(this).getNotes()

        val listOfNotes:MutableList<DataModel> = notesDao.getAllNotes()


        binding.rec.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerAdapter(this, listOfNotes)
        binding.rec.adapter = adapter


        binding.floatingActionButton.setOnClickListener {
            val goToAddData = Intent(this,AddNotesActivity::class.java)
            startActivity(goToAddData)
            finish()
        }



    }

}