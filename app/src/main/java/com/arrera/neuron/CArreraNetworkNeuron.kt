package com.arrera.neuron

import kotlin.random.Random

class CArreraNetworkNeuron( private val nameAssistant:String,  private val but:String, private val  vous:Boolean, private val genre:String, private val user:String) {

    private val aDate : CArreraDate = CArreraDate()
    private val gestionnaite : CGestionnaireNeuron = CGestionnaireNeuron(this.nameAssistant,this.but,this.vous,this.genre,this.user)
    private val nFormulation : CNeuronFormulation = CNeuronFormulation(gestionnaite,aDate);
    fun neuron()
    {

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