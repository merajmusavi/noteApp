package com.example.noteukt.Activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.noteukt.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var prefrences:SharedPreferences
    lateinit var editor:SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefrences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)
        editor = prefrences.edit()
        editor.apply()
binding.btnLogin.setOnClickListener {

        if (binding.editTextTextPersonName.text.isEmpty() || binding.editTextpssword.text.isEmpty()) {

            Toast.makeText(this, "لطفا مقادیر مد نظر را پر کنید", Toast.LENGTH_SHORT).show()
        } else {

                val user = binding.editTextTextPersonName.text.toString()
                val password = binding.editTextpssword.text.toString()

                val firstStartBefore:Boolean = prefrences.getBoolean("firstLogin",false)

                if (firstStartBefore){

                    val username = prefrences.getString("username","")
                    val pass = prefrences.getString("pass","")
                    if (username==user && password==pass){
                        val  intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }

                }else{
                    editor.putString("username",user).apply()
                    editor.putString("pass",password).apply()
                    editor.putBoolean("firstLogin",true).apply()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }





        }
}

    }
}