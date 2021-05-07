package com.example.spread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.TextView

class SirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sir)

        val actionBar = supportActionBar

        actionBar!!.title = "SIR Model"

        actionBar.setDisplayHomeAsUpEnabled(true)

        setupHyperlink()

        val nextBtn = findViewById<Button>(R.id.nextBtn)
        nextBtn.setOnClickListener {
            val intent = Intent(this, ConfigureSirModelActivity::class.java)
            startActivity(intent)
        }
    }
    fun setupHyperlink() {
        val linkTextView = findViewById<TextView>(R.id.activity_sir_link)
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}