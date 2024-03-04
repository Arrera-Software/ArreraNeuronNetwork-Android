package com.arrera.neuron


import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CfArreraMeteo {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/weather/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val interfaceMeteo = retrofit.create(fMeteoInterface::class.java)
    private var requetteOK = false


    fun data(latitude:String,longitude:String,callback: fMeteoSortie) {
        val result = interfaceMeteo.getData(latitude,longitude)
        result.enqueue(object :Callback<JsonObject>{
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if( response.isSuccessful) {
                    val resultMeteo = response.body()
                    val main = resultMeteo?.get("main")?.asJsonObject
                    val weather = resultMeteo?.get("weather")?.asJsonArray?.get(0)?.asJsonObject
                    val temp = main?.get("temp")?.asDouble.toString()
                    val ville = resultMeteo?.get("name").toString().replace('"',' ')
                    val description = weather?.get("description").toString().replace('"',' ')
                    callback.onTemperatureReceived(temp,ville,description)
                }
                else
                {
                    callback.onError("Erreur de réseau")

                }
            }
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                callback.onError("Erreur de réseau")
            }
        })

    }

}