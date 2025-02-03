package com.example.anuk_guerraizquierdo_uf1_act20

import androidx.lifecycle.lifecycleScope
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDownload = findViewById<Button>(R.id.btnDownload)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        btnDownload.setOnClickListener {
            tvStatus.text = "Descarregant..."

            lifecycleScope.launch(Dispatchers.IO) {
                val delayTime = Random.nextLong(1000, 5000)
                delay(delayTime)

                withContext(Dispatchers.Main) {
                    tvStatus.text = "Descarregat correctament!"
                }
            }
        }
    }
}