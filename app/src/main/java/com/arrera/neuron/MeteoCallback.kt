package com.arrera.neuron

interface MeteoCallback {
    fun onTemperatureReceived(temperature: String)
    fun onError(error: String)
}