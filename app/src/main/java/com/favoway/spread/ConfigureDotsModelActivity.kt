package com.favoway.spread

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class ConfigureDotsModelActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configure_dots_model)

        val durationSeekBar: SeekBar = findViewById(R.id.durationSeekBarDots)
        val durationNumber: TextView = findViewById(R.id.durationNumberDots)
        var durationInt = 7

        val opportunitiesSeekBar: SeekBar = findViewById(R.id.opportunitiesSeekBarDots)
        val opportunitiesNumber: TextView = findViewById(R.id.opportunitiesNumberDots)
        var opportunitiesInt = 5

        val transmissionSeekBar: SeekBar = findViewById(R.id.transmissionSeekBarDots)
        val transmissionNumber: TextView = findViewById(R.id.transmissionNumberDots)
        var transmissionFloat = 0.05

        val susceptibilitySeekBar: SeekBar = findViewById(R.id.susceptibilitySeekBarDots)
        val susceptibilityNumber: TextView = findViewById(R.id.susceptibilityNumberDots)
        var susceptibilityFloat = 0.7

        val sumDots: TextView = findViewById(R.id.sumDots)

            durationSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                durationNumber.text = progress.toString()
                durationInt = progress
                sumDots.text = (Math.round((durationInt*opportunitiesInt*transmissionFloat*susceptibilityFloat)* 1000) / 1000.0).toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })



        opportunitiesSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                opportunitiesNumber.text = progress.toString()
                opportunitiesInt = progress
                sumDots.text = (Math.round((durationInt*opportunitiesInt*transmissionFloat*susceptibilityFloat)* 1000) / 1000.0).toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        transmissionSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val valueTransmission = (progress.toFloat() / 100.0)
                transmissionNumber.text = "$progress%"
                transmissionFloat = valueTransmission

                sumDots.text = (Math.round((durationInt*opportunitiesInt*transmissionFloat*susceptibilityFloat)* 1000) / 1000.0).toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        susceptibilitySeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val value = (progress.toFloat() / 100.0)
                susceptibilityFloat = value
                susceptibilityNumber.text = "$progress%"

                sumDots.text = (Math.round((durationInt*opportunitiesInt*transmissionFloat*susceptibilityFloat)* 1000) / 1000.0).toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        val actionBar = supportActionBar

        actionBar!!.title = "DOTS Model"

        actionBar.setDisplayHomeAsUpEnabled(true)

    }
}