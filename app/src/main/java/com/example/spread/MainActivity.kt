package com.example.spread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sirActivityBtn = findViewById<Button>(R.id.sirActivityBtn)
        sirActivityBtn.setOnClickListener {
            val intent = Intent(this, SirActivity::class.java)
            startActivity(intent)
        }
    }
}