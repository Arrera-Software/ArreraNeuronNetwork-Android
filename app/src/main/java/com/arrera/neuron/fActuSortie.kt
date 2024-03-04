package com.arrera.neuron

interface fActuSortie {
    fun onDataReceived(titre1:String,titre2:String,titre3:String)
    fun onError(error: String)
}