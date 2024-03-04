package com.arrera.neuron

interface fMeteoSortie {
    fun onDataReceived(temperature: String, ville:String, description:String)
    fun onError(error: String)
}