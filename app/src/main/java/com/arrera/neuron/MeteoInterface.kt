package com.arrera.neuron

import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.Call

interface MeteoInterface {
    @GET("?q=Paris&appid=19bfbee6112be5b3d9a64d4ccec72602&units=metric")
    fun getData(): Call<JsonObject>
}