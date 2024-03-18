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
        var etatVous =  gestionnaire.etatVous
        var genre = gestionnaire.genre
        var user = gestionnaire.user
        if(requette.contains("recherche"))
        {
            val url = "https://www.google.com/search?q="+requette.replace("recherche","")
            web.open(url);
            sortietext = "Voici votre recherche"
        }
        else
        {
            if (requette.contains("youtube"))
            {
                sortietext = "voici youtube"
                web.open("https://www.youtube.com/")
            }
            else
            {
               if(requette.contains("musique")||requette.contains("yt music")||requette.contains("music"))
               {
                   if (etatVous)
                   {
                       sortietext = "Ok "+genre+" "+user+" je vous ouvre Youtube Music."
                   }
                   else
                   {
                       sortietext = "Voici Youtube Music "+user
                   }
                   web.open("https://music.youtube.com/")
               }
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