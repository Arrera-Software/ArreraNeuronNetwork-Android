package com.arrera.neuron

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CfArreraActu {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val interfaceActu = retrofit.create(fActuInterface::class.java)

    fun data(callback: fActuSortie)
    {
        val result = interfaceActu.getData()
        result.enqueue(object :Callback<JsonObject>{
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if( response.isSuccessful) {
                    var sortieActu = response.body()
                    var article = sortieActu?.get("articles")?.asJsonArray
                    var titre1 = article?.get(0)?.asJsonObject?.get("title").toString().replace('"',' ').replace("/","")
                    var titre2 = article?.get(1)?.asJsonObject?.get("title").toString().replace('"',' ').replace("/","")
                    var titre3 = article?.get(2)?.asJsonObject?.get("title").toString().replace('"',' ').replace("/","")

                    callback.onDataReceived(titre1,titre2,titre3)
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
}}