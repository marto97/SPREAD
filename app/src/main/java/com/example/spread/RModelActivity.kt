package com.example.spread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_r_model)

        val actionBar = supportActionBar

        actionBar!!.title = "R Model"

        actionBar.setDisplayHomeAsUpEnabled(true)
    }
}