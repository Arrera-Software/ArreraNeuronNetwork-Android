package com.arrera.neuron

import kotlin.random.Random

class CArreraNetworkNeuron( private val nameAssistant:String,  private val but:String, private val  vous:Boolean, private val genre:String, private val user:String) {

    private val aDate : CArreraDate = CArreraDate()
    private val gestionnaite : CGestionnaireNeuron = CGestionnaireNeuron(this.nameAssistant,this.but,this.vous,this.genre,this.user)
    private val nFormulation : CNeuronFormulation = CNeuronFormulation(gestionnaite,aDate);
    private val nChat : CNeuronChat = CNeuronChat(gestionnaite,nFormulation);
    private val fMeteo: CfArreraMeteo = CfArreraMeteo();

    fun neuron(requette :String ,latitude:String,longitude:String ,callback: (String) -> Unit)
    {
        var sortieNb = 0
        nChat.neuron(requette);
        sortieNb = nChat.outNeuronNb();
        if (sortieNb == 0 )
        {
            if (requette.contains("meteo"))
            {
                fMeteo.data(latitude,longitude,object : fMeteoSortie {
                    override fun onTemperatureReceived(temperature: String,ville :String,description:String) {
                        val random = Random.nextInt(1,2)
                        if (random==1) {
                            callback("La meteo a$ville" + "est$description" + "avec une temperature de $temperature °C.")
                        }
                        else
                        {
                            if (gestionnaite.etatVous==true)
                            {
                                callback("La meteo a votre localisation est$description" + "avec une temperature de $temperature °C.")
                            }
                            else
                            {
                                callback("La meteo a ta localisation est$description" + "avec une temperature de $temperature °C.")
                            }
                        }
                    }

                    override fun onError(error: String) {
                        callback(error)
                    }
                })
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

    fun bonjour():String
    {
        return nFormulation.salutation()
    }

    fun aurevoir():String
    {
        return nFormulation.aurevoir()
    }
}