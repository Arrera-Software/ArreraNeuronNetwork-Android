package com.arrera.neuron

interface fMeteoSortie {
    fun onTemperatureReceived(temperature: String,ville:String,description:String)
    fun onError(error: String)
}