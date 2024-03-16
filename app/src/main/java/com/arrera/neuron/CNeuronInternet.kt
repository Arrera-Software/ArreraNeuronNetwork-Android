package com.arrera.neuron

import android.content.Context

class CNeuronInternet(private val const: Context,
                      private val gestText :CArreraGestionText,
                      private val gestionnaire : CGestionnaireNeuron)
{
    private var sortietext : String = ""
    private val web = ArreraWebbrowser(const)

    fun neuron(requette:String)
    {
        if(requette.contains("recherche"))
        {
            val url = "https://www.google.com/search?q="+requette.replace("recherche","")
            web.open(url);
            sortietext = "Voici votre recherche"
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