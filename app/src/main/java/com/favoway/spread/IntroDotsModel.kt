package com.favoway.spread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.TextView

class IntroDotsModel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_dots_model)

        val actionBar = supportActionBar

        actionBar!!.title = "DOTS Model"

        actionBar.setDisplayHomeAsUpEnabled(true)

        setupHyperlink()

        val nextBtnDots = findViewById<Button>(R.id.nextBtnDots)
        nextBtnDots.setOnClickListener {
            val intent = Intent(this, ConfigureDotsModelActivity::class.java)
            startActivity(intent)
        }
    }

    fun setupHyperlink() {
        val linkTextView = findViewById<TextView>(R.id.activity_dots_link)
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}