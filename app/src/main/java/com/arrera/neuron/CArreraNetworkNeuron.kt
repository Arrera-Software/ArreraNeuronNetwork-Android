package com.arrera.neuron

import kotlin.random.Random

class CArreraNetworkNeuron( private val nameAssistant:String,  private val but:String, private val  vous:Boolean, private val genre:String, private val user:String) {

    private val aDate : CArreraDate = CArreraDate()
    private val gText : CArreraGestionText = CArreraGestionText()
    private val gestionnaite : CGestionnaireNeuron = CGestionnaireNeuron(this.nameAssistant,this.but,this.vous,this.genre,this.user,gText)
    private val nFormulation : CNeuronFormulation = CNeuronFormulation(gestionnaite,aDate);
    private val nChat : CNeuronChat = CNeuronChat(gestionnaite,nFormulation);
    private val fMeteo: CfArreraMeteo = CfArreraMeteo();
    private val fActu : CfArreraActu = CfArreraActu()
    fun neuron(requette :String ,latitude:String,longitude:String ,callback: (String) -> Unit)
    {
        var sortieNb = 0
        var sortieText = ""
        var requetteFormater = gText.formatageText(requette)
        nChat.neuron(requetteFormater);
        sortieNb = nChat.outNeuronNb();
        if (sortieNb == 0 )
        {
            if (requetteFormater.contains("meteo"))
            {
                fMeteo.data(latitude,longitude,object : fMeteoSortie {
                    override fun onDataReceived(temperature: String, ville :String, description:String) {
                        val random = Random.nextInt(1,2)
                        if (random==1) {
                            sortieText = "La meteo a$ville" + "est$description" + "avec une temperature de $temperature °C."
                            gestionnaite.setOldSortie(sortieText)
                            callback(sortieText)
                        }
                        else
                        {
                            if (gestionnaite.etatVous==true)
                            {
                                sortieText = "La meteo a votre localisation est$description" + "avec une temperature de $temperature °C."
                                gestionnaite.setOldSortie(sortieText)
                                callback(sortieText)
                            }
                            else
                            {
                                sortieText =("La meteo a ta localisation est$description" + "avec une temperature de $temperature °C.")
                                gestionnaite.setOldSortie(sortieText)
                                callback(sortieText)
                            }
                        }
                    }

                    override fun onError(error: String) {
                        sortieText =(error)
                        gestionnaite.setOldSortie(sortieText)
                        callback(sortieText)
                    }
                })
            }
            else
            {
                if(requetteFormater.contains("actu"))
                {
                    fActu.data(object :fActuSortie{
                        override fun onDataReceived(titre1: String,titre2: String) {
                            sortieText =("Les actualités sont $titre1 et $titre2")
                            gestionnaite.setOldSortie(sortieText)
                            callback(sortieText)
                    }

                        override fun onError(error: String) {
                            sortieText =(error)
                            gestionnaite.setOldSortie(sortieText)
                            callback(sortieText)
                        }
                    })
                }
                else
                {
                    sortieText =(nFormulation.nocomprehension());
                    gestionnaite.setOldSortie(sortieText)
                    callback(sortieText)
                }
            }
        }
        else
        {
            sortieText =(nChat.outNeuronText())
            gestionnaite.setOldSortie(sortieText)
            callback(sortieText)
        }
    }

    fun bonjour():String
    {
        gestionnaite.setOldSortie("boot")
        return nFormulation.salutation()
    }

    fun aurevoir():String
    {
        gestionnaite.setOldSortie("au revoir")
        return nFormulation.aurevoir()
    }
}