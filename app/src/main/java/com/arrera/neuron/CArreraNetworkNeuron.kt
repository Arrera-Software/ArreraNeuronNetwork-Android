package com.arrera.neuron

import kotlin.random.Random

class CArreraNetworkNeuron( private val nameAssistant:String,  private val but:String, private val  vous:Boolean, private val genre:String, private val user:String) {

    private val aDate : CArreraDate = CArreraDate()
    private val gestionnaite : CGestionnaireNeuron = CGestionnaireNeuron(this.nameAssistant,this.but,this.vous,this.genre,this.user)
    private val nFormulation : CNeuronFormulation = CNeuronFormulation(gestionnaite,aDate);
    private val nChat : CNeuronChat = CNeuronChat(gestionnaite,nFormulation);
    private var sortieText : String = "" ;
    private var sortieNb : Int = 0 ;
    fun neuron(requette :String)
    {
        nChat.neuron(requette);
        sortieNb = nChat.outNeuronNb();
        if (sortieNb == 0 )
        {
            sortieText = nFormulation.nocomprehension();
        }
        else
        {
            sortieText = nChat.outNeuronText()
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