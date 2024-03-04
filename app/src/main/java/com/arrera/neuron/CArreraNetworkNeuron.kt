package com.arrera.neuron

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

class CArreraNetworkNeuron( private val nameAssistant:String,  private val but:String, private val  vous:Boolean, private val genre:String, private val user:String) {

    private val aDate : CArreraDate = CArreraDate()
    private val gestionnaite : CGestionnaireNeuron = CGestionnaireNeuron(this.nameAssistant,this.but,this.vous,this.genre,this.user)
    private val nFormulation : CNeuronFormulation = CNeuronFormulation(gestionnaite,aDate);
    private val nChat : CNeuronChat = CNeuronChat(gestionnaite,nFormulation);
    private val fMeteo: MeteoClass = MeteoClass();
    private var sortieText : String = "" ;
    private var sortieNb : Int = 0 ;

    fun neuron(requette :String ,latitude:String,longitude:String ,callback: (String) -> Unit)
    {
        nChat.neuron(requette);
        sortieNb = nChat.outNeuronNb();
        if (sortieNb == 0 )
        {
            if (requette=="meteo")
            {
                fMeteo.data(latitude,longitude,object : MeteoCallback {
                    override fun onTemperatureReceived(temperature: String,ville :String,description:String) {
                        callback("La meteo a$ville"+"est$description"+"avec une temperature de $temperature °C.")
                    }

                    override fun onError(error: String) {
                        callback(error)
                    }
                })
                sortieNb = 1
            }
            else
            {
                callback(nFormulation.nocomprehension());
            }
        }
        else
        {
            callback(nChat.outNeuronText())
        }
    }

    fun outNeuronText() :String
    {
        return sortieText
    }

    fun outNeuronNb () :Int
    {
        return sortieNb
    }

    fun bonjour():String
    {
        return nFormulation.salutation()
    }

    fun aurevoir():String
    {
        return nFormulation.aurevoir()
    }
}