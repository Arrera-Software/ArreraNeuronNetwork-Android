package com.arrera.neuron

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Declaration widget
        val msgOUT = findViewById<TextView>(R.id.IDC_OUTNEURON);
        val msgIN = findViewById<TextView>(R.id.IDC_INMSG);
        val btnSend = findViewById<Button>(R.id.IDC_SEND);
        // declaration du neuron
        val arreraNeuron = CArreraNetworkNeuron("Opale", "but", true, "Monsieur", "dev");
        // demarage
        msgOUT.setText("Opale : "+arreraNeuron.bonjour());
        btnSend.setOnClickListener() {
            val text = msgIN.text.toString();
            msgIN.setText("");
            arreraNeuron.neuron(text) { response ->
                runOnUiThread {
                    msgOUT.setText("Opale : $response")
                }
            }

        }
    }
}