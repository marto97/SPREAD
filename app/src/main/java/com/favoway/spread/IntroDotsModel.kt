package com.favoway.spread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView

class IntroDotsModel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_dots_model)

        val actionBar = supportActionBar

        actionBar!!.title = "DOTS Model"

        actionBar.setDisplayHomeAsUpEnabled(true)

        setupHyperlink()
    }

    fun setupHyperlink() {
        val linkTextView = findViewById<TextView>(R.id.activity_dots_link)
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}