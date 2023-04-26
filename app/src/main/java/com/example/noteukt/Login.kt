package com.example.noteukt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.noteukt.databinding.ActivityLoginBinding
import com.example.noteukt.databinding.ActivityMainBinding

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (binding.editTextTextPersonName.text.isEmpty() || binding.editTextpssword.text.isEmpty()) {
            Toast.makeText(this, "لطفا مقادیر مد نظر را پر کنید", Toast.LENGTH_SHORT).show()
        } else {

            binding.btnLogin.setOnClickListener {
                var intent = Intent(this, MainActivity::class.java)
                intent.putExtra("name", "meraj")
                startActivity(intent)
            }


        }

    }
}