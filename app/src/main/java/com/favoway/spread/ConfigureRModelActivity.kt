package com.favoway.spread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class ConfigureRModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configure_r_model)

        val susceptibleSeekBar: SeekBar = findViewById(R.id.susceptibleSeekBarR)
        val susceptibleNumber: TextView = findViewById(R.id.susceptibleNumberR)

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

        val infectedSeekBar: SeekBar = findViewById(R.id.infectedSeekBarR)
        val infectedNumber: TextView = findViewById(R.id.infectedNumberR)

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

        val recoveredSeekBar: SeekBar = findViewById(R.id.recoveredSeekBarR)
        val recoveredNumber: TextView = findViewById(R.id.recoveredNumberR)

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

        val rNumberSeekBar: SeekBar = findViewById(R.id.RNumberSeekBarR)
        val rNumberNumber: TextView = findViewById(R.id.RNumberR)

        //var rNumberInt = 1

        rNumberSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val value = (progress.toFloat() / 10.0).toFloat()
                rNumberNumber.text = value.toString()
                //rNumberInt = value.toInt()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        val actionBar = supportActionBar

        actionBar!!.title = "R Number"

        actionBar.setDisplayHomeAsUpEnabled(true)

        val startBtnR = findViewById<Button>(R.id.startBtnR)
        startBtnR.setOnClickListener {
            val intent = Intent(this@ConfigureRModelActivity, CanvasViewR::class.java)
            intent.putExtra("susceptibleInt",susceptibleInt)
            intent.putExtra("infectedInt",infectedInt)
            intent.putExtra("recoveredInt",recoveredInt)
            startActivity(intent)
        }
    }
}