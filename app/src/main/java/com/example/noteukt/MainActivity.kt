package com.example.noteukt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
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

        binding.floatingActionButton.setOnClickListener {
            showDialog()
        }

        binding.rec.layoutManager = LinearLayoutManager(this)

        binding.rec.adapter = RecyclerAdapter(this)


    }

    fun showDialog() {
        val view: View = LayoutInflater.from(this).inflate(R.layout.add_note_dialog, null)
        AlertDialog.Builder(this).setView(view).create().show()
    }
}