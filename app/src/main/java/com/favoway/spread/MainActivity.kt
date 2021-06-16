package com.favoway.spread

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

        val rActivityBtn = findViewById<Button>(R.id.rActivityBtn)
        rActivityBtn.setOnClickListener {
            val intent = Intent(this, RModelActivity::class.java)
            startActivity(intent)
        }

        val introDotsActivityBtn = findViewById<Button>(R.id.introDotsActivityBtn)
        introDotsActivityBtn.setOnClickListener {
            val intent = Intent(this, IntroDotsModel::class.java)
            startActivity(intent)
        }

    }
}