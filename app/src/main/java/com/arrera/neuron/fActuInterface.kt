package com.arrera.neuron

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET


interface fActuInterface {
    @GET("top-headlines?apiKey=3b43e18afcf945888748071d177b8513&country=fr&category=general&language=fr&pageSize=3")
    fun getData() : Call<JsonObject>
}