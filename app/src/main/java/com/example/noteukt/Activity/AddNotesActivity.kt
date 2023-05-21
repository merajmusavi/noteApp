package com.example.noteukt.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.example.noteukt.DataBase.DataBase
import com.example.noteukt.DataBase.DataModel
import com.example.noteukt.DataBase.NotesDao
import com.example.noteukt.R
import com.example.noteukt.databinding.ActivityAddNotesBinding

class AddNotesActivity : AppCompatActivity() {
    lateinit var binding:ActivityAddNotesBinding
    lateinit var note:NotesDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        note = DataBase.createDataBase(this).getNotes()
        val intent = intent

        val isClickedToView = intent.getBooleanExtra("clickedOnItem",false)
        val position = intent.getIntExtra("position",0)

        if (isClickedToView){
            binding.title.isEnabled = false
            binding.desc.isEnabled = false
            binding.btnSave.visibility = View.GONE
            binding.textView2.text = getString(R.string.showNotes)
            val list:MutableList<DataModel> = note.getAllNotes()
            binding.title.setText(list[position].title)
            binding.desc.setText(list[position].description)

        }




        binding.btnSave.setOnClickListener {
            val data = DataModel(title = binding.title.text.toString(), description = binding.desc.text.toString())
            note.addNote(data)
            startActivity(Intent(this,MainActivity::class.java))
        }

        Log.d("porshode", ""+note.getAllNotes())


    }
}