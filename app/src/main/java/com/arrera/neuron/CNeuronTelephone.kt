package com.arrera.neuron

import android.content.Context

class CNeuronTelephone(private val const: Context,
                       private val gestText :CArreraGestionText,
                       private val gestionnaire : CGestionnaireNeuron)
{
    private var sortietext : String = ""
    private var etatVous = gestionnaire.etatVous
    private var genre = gestionnaire.genre
    private var user = gestionnaire.user
    private var oldRequette = gestionnaire.oldrequette
    private var oldSortie = gestionnaire.oldSortie
    fun neuron(requette:String)
    {
        if (requette.contains("envoi un sms"))
        {
            if (etatVous)
            {
                sortietext = "A quel numero voulez-vous envoyer le message "+genre+" "+user+"."
            }
            else
            {
                sortietext = "Quel est le numero que tu veux envoyer un message "+user
            }
            gestionnaire.setOldSortie(sortietext)
        }
        else
        {
            if ((requette.contains("07")||requette.contains("06"))&&
                (oldSortie.contains("A quel numero voulez-vous envoyer le message")||
                        oldSortie.contains("Quel est le numero que tu veux envoyer un message")))
            {
                sortietext = "Ok quel est le message ?"
            }
        }
    }

    fun outNeuronText() :String
    {
        return  this.sortietext
    }

    fun outNeuronNb () :Int
    {
        return gestText.testOut(sortietext)
    }
}