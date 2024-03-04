package com.arrera.neuron

import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface fMeteoInterface {
    @GET("?appid=19bfbee6112be5b3d9a64d4ccec72602&units=metric&lang=fr")
    fun getData(@Query("lat") lat:String,@Query("lon") lon:String): Call<JsonObject>
}