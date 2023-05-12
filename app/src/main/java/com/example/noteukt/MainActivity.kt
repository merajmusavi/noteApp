package com.example.noteukt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteukt.databinding.ActivityMainBinding
import com.example.noteukt.databinding.AddNoteDialogBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent

        binding.floatingActionButton.setOnClickListener {
            showDialog()
        }


    }

    fun showDialog() {
        val dialogBinding: AddNoteDialogBinding =
            AddNoteDialogBinding.inflate(LayoutInflater.from(this))

        val alert = AlertDialog.Builder(this).setView(dialogBinding.root).create()

        binding.rec.layoutManager = LinearLayoutManager(this)
        val data = mutableListOf<DataModel>()

        val adapter = RecyclerAdapter(this, data)
        binding.rec.adapter = adapter

        dialogBinding.btnConfirm.setOnClickListener {
            data.add(DataModel(dialogBinding.editTextTextPersonName.text.toString(), ""))


        }

        alert.show()


    }
}