package com.example.noteukt.Activity

import android.content.BroadcastReceiver
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

class MainActivity : AppCompatActivity(),RecyclerAdapter.OnDeleteButtonClick {
    lateinit var binding: ActivityMainBinding
    lateinit var notesDao: NotesDao
    lateinit var receiver:BroadcastReceiver
    lateinit var listOfNotes: MutableList<DataModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        val isDeleteBtnClicked = intent.getBooleanExtra("clickedOnItem1",false)
        val position = intent.getIntExtra("position1",0)




        notesDao = DataBase.createDataBase(this).getNotes()





       listOfNotes = notesDao.getAllNotes()


        binding.rec.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerAdapter(this, listOfNotes)
        binding.rec.adapter = adapter



        binding.floatingActionButton.setOnClickListener {
            val goToAddData = Intent(this, AddNotesActivity::class.java)
            startActivity(goToAddData)
            finish()
        }


    }

    override fun onDeleteClicked(position: Int) {
        notesDao.deleteItemById(position.toLong())
        listOfNotes.removeAt(position)
        binding.rec.adapter?.notifyItemRemoved(position)
    }

}