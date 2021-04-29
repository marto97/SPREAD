package com.example.spread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ConfigureSirModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configure_sir_model)

        val actionBar = supportActionBar

        actionBar!!.title = "SIR Model"

        actionBar.setDisplayHomeAsUpEnabled(true)
    }
}