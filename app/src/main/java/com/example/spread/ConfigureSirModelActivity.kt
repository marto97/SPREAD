package com.example.spread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import org.w3c.dom.Text

class ConfigureSirModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configure_sir_model)

        val susceptibleSeekBar: SeekBar = findViewById(R.id.susceptibleSeekBar)
        val susceptibleNumber: TextView = findViewById(R.id.susceptibleNumber)

        var susceptibleInt: Int = 25

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

        var infectedInt: Int = 25

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

        val actionBar = supportActionBar

        actionBar!!.title = "SIR Model"

        actionBar.setDisplayHomeAsUpEnabled(true)


        // finding the edit text
        //val editText = findViewById<View>(R.id.editTextNumberDecimal)


        val startBtn = findViewById<Button>(R.id.startBtn)
        startBtn.setOnClickListener {
            val intent = Intent(this@ConfigureSirModelActivity, CanvasView::class.java)
            intent.putExtra("susceptibleInt",susceptibleInt)
            intent.putExtra("infectedInt",infectedInt)
            startActivity(intent)
        }
    }
}