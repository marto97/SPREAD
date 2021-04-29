package com.example.spread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sir)

        val actionBar = supportActionBar

        actionBar!!.title = "SIR Model"

        actionBar.setDisplayHomeAsUpEnabled(true)

        val nextBtn = findViewById<Button>(R.id.nextBtn)
        nextBtn.setOnClickListener {
            val intent = Intent(this, ConfigureSirModelActivity::class.java)
            startActivity(intent)
        }
    }
}