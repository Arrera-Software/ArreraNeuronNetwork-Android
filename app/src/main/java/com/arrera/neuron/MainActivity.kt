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
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() , LocationListener  {

    private var latitude = ""
    private var longitude = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val locationManager : LocationManager
        setContentView(R.layout.activity_main)
        // Declaration widget
        val msgOUT = findViewById<TextView>(R.id.IDC_OUTNEURON);
        val msgIN = findViewById<TextView>(R.id.IDC_INMSG);
        val btnSend = findViewById<Button>(R.id.IDC_SEND);
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
        // declaration du neuron
        val arreraNeuron = CArreraNetworkNeuron(
            "Opale",
            "developper un algorythme d'assistant pour telephone Android",
            true,
            "Monsieur",
            "dev",
            "Baptiste Pauchet");
        // demarage
        msgOUT.setText("Opale : "+arreraNeuron.bonjour());

        btnSend.setOnClickListener() {
            val text = msgIN.text.toString();
            getLocation()
            msgIN.setText("");
            arreraNeuron.neuron(text,latitude,longitude) { response ->
                runOnUiThread {
                    msgOUT.setText("Opale : $response")
                }
            }

        }
    }

    private fun getLocation() {
        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 100)
        } else {
            val lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            lastKnownLocation?.let {
                latitude = it.latitude.toString()
                longitude = it.longitude.toString()

            }
        }
    }

    override fun onLocationChanged(location: Location) {
        //Toast.makeText(this, "${location.latitude},${location.longitude}", Toast.LENGTH_SHORT).show()
        try {
            latitude = location.latitude.toString()
            longitude=location.longitude.toString()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}