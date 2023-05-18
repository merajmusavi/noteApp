package com.example.noteukt.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.noteukt.DataBase.DataModel
import com.example.noteukt.databinding.ActivityAddNotesBinding

class AddNotesActivity : AppCompatActivity() {
    lateinit var binding:ActivityAddNotesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val title = binding.title.text.toString()
        val desc = binding.desc.text.toString()

        val notes = mutableListOf<DataModel>()

        notes.add(DataModel(title=title,description=desc))


    }
}