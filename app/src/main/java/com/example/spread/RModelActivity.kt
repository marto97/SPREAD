package com.example.spread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView

class RModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_r_model)

        val actionBar = supportActionBar

        actionBar!!.title = "R Model"

        actionBar.setDisplayHomeAsUpEnabled(true)
        setupHyperlink()
    }
    fun setupHyperlink() {
        val linkTextView = findViewById<TextView>(R.id.activity_r_link)
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance())
    }
}