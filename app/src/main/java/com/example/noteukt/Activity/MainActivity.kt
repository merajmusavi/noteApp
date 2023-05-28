package com.example.noteukt.Activity

import android.content.BroadcastReceiver
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteukt.DataBase.DataModel
import com.example.noteukt.R
import com.example.noteukt.Adapter.RecyclerAdapter
import com.example.noteukt.DataBase.DataBase
import com.example.noteukt.DataBase.NotesDao
import com.example.noteukt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), RecyclerAdapter.OnButtonClickListener {
    lateinit var binding: ActivityMainBinding
    lateinit var notesDao: NotesDao
    lateinit var receiver: BroadcastReceiver
    lateinit var listOfNotes: MutableList<DataModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent




        notesDao = DataBase.createDataBase(this).getNotes()





        listOfNotes = notesDao.getAllNotes()



        binding.rec.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerAdapter(this, listOfNotes)
        adapter.setonButtonClickListener(this)
        binding.rec.adapter = adapter


        Log.d("see id", "onCreate: " + listOfNotes)

        binding.floatingActionButton.setOnClickListener {
            val goToAddData = Intent(this, AddNotesActivity::class.java)
            startActivity(goToAddData)
            finish()
        }


    }

    override fun onButtonClicked(position: Int) {
        val item = listOfNotes[position]
        notesDao.deleteItemById(item.id.toLong())
        listOfNotes.removeAt(position)
        binding.rec.adapter?.notifyItemRemoved(position)

    }

    override fun onButtonLongClicked(position: Int) {
        val goToAddData = Intent(this, AddNotesActivity::class.java)
        intent.putExtra("isOnLongClicked",true)
        startActivity(goToAddData)

    }


}