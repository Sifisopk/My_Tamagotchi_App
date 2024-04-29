package com.example.my_tamagotchi_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.startBtn)

        // code for linking the two activities
        startBtn.setOnClickListener{
            intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}