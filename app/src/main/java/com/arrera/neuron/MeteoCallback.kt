package com.arrera.neuron

interface MeteoCallback {
    fun onTemperatureReceived(temperature: String,ville:String,description:String)
    fun onError(error: String)
}