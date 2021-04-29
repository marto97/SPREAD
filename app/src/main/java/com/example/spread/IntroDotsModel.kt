package com.example.spread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class IntroDotsModel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_dots_model)

        val actionBar = supportActionBar

        actionBar!!.title = "DOTS Model"

        actionBar.setDisplayHomeAsUpEnabled(true)
    }
}