package com.favoway.spread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class ConfigureSirModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configure_sir_model)

        val susceptibleSeekBar: SeekBar = findViewById(R.id.susceptibleSeekBar)
        val susceptibleNumber: TextView = findViewById(R.id.susceptibleNumber)

        var susceptibleInt = 25

        susceptibleSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                susceptibleNumber.text = progress.toString()
                susceptibleInt = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        val infectedSeekBar: SeekBar = findViewById(R.id.infectedSeekBar)
        val infectedNumber: TextView = findViewById(R.id.infectedNumber)

        var infectedInt = 25

        infectedSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                infectedNumber.text = progress.toString()
                infectedInt = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        val recoveredSeekBar: SeekBar = findViewById(R.id.recoveredSeekBar)
        val recoveredNumber: TextView = findViewById(R.id.recoveredNumber)

        var recoveredInt = 25

        recoveredSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                recoveredNumber.text = progress.toString()
                recoveredInt = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        val durationSeekBar: SeekBar = findViewById(R.id.durationSeekBarSIR)
        val durationNumber: TextView = findViewById(R.id.durationNumberSIR)

        var durationInt = 25

        durationSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                durationNumber.text = progress.toString()
                durationInt = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        val actionBar = supportActionBar

        actionBar!!.title = "SIR Model"

        actionBar.setDisplayHomeAsUpEnabled(true)

        val startBtn = findViewById<Button>(R.id.startBtn)
        startBtn.setOnClickListener {
            val intent = Intent(this@ConfigureSirModelActivity, CanvasViewSIR::class.java)
            intent.putExtra("susceptibleInt",susceptibleInt)
            intent.putExtra("infectedInt",infectedInt)
            intent.putExtra("recoveredInt",recoveredInt)
            intent.putExtra("durationInt",durationInt)
            startActivity(intent)
        }
    }
}