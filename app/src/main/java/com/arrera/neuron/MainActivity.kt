package com.arrera.neuron

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val msgOUT = findViewById<TextView>(R.id.IDC_OUTNEURON);
        val msgIN = findViewById<TextView>(R.id.IDC_INMSG);
        val btnSend = findViewById<Button>(R.id.IDC_SEND);

        btnSend.setOnClickListener(){
            val text = msgIN.text.toString();
            
        }
    }
}