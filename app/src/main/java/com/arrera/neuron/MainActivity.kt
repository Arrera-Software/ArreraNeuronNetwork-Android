package com.arrera.neuron

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import  android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() , LocationListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val locationManager : LocationManager
        setContentView(R.layout.activity_main)
        // Declaration widget
        val msgOUT = findViewById<TextView>(R.id.IDC_OUTNEURON);
        val msgIN = findViewById<TextView>(R.id.IDC_INMSG);
        val btnSend = findViewById<Button>(R.id.IDC_SEND);
        // declaration du neuron
        val arreraNeuron = CArreraNetworkNeuron("Opale", "but", true, "Monsieur", "dev");
        // demarage
        msgOUT.setText("Opale : "+arreraNeuron.bonjour());
        // Localisation
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED
            ){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),100)
        }
        try {
            val locationManager = applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this@MainActivity)
        } catch (e: Exception) {
            e.printStackTrace()
        }

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

    override fun onLocationChanged(location: Location) {
    }


}