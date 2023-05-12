package com.example.noteukt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteukt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent

        val view: View = LayoutInflater.from(this).inflate(R.layout.add_note_dialog, null)
        val alert = AlertDialog.Builder(this).setView(view).create()

        val et:EditText = view.findViewById(R.id.editTextTextPersonName)

        val btnConfirm:Button = view.findViewById(R.id.btnLogin)




        binding.rec.layoutManager = LinearLayoutManager(this)
        val data = mutableListOf<DataModel>()
        val adapter = RecyclerAdapter(this, data)
        binding.rec.adapter = adapter

        btnConfirm.setOnClickListener {
            data.add(DataModel(et.text.toString(),""))
            alert.hide()
        }


        binding.floatingActionButton.setOnClickListener {
alert.show()

        }



    }

}