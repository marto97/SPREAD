package com.favoway.spread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.TextView

class RModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_r_model)

        val actionBar = supportActionBar

        actionBar!!.title = "R Model"

        actionBar.setDisplayHomeAsUpEnabled(true)
        setupHyperlink()

        val nextBtnR = findViewById<Button>(R.id.nextBtnR)
        nextBtnR.setOnClickListener {
            val intent = Intent(this, ConfigureRModelActivity::class.java)
            startActivity(intent)
        }
    }
    fun setupHyperlink() {
        val linkTextView = findViewById<TextView>(R.id.activity_r_link)
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance())
    }
}