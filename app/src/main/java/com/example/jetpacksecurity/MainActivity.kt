package com.example.jetpacksecurity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences =SharedPreferences(this,"shared_file.txt")
        val sharedPrefsEditor = sharedPreferences.sharedPrefsEditor
        sharedPrefsEditor.edit().putString("key1","value1").apply()
        print("The value is ${sharedPrefsEditor.getString("key1","error")}")
    }
}