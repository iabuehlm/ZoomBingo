package com.example.zoombingo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences

class MainActivity : AppCompatActivity() {

    companion object {
        var preferences: SharedPreferences? = null
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        preferences = getSharedPreferences( getPackageName() + "_preferences", MODE_PRIVATE);

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
