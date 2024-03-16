package com.arrera.neuron

import android.content.Context
import android.content.Intent
import android.location.Geocoder
import android.location.Geocoder.GeocodeListener
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.startActivity
import kotlin.random.Random

class CArreraNetworkNeuron(private val nameAssistant:String,
                           private val but:String,
                           private val  vous:Boolean,
                           private val genre:String,
                           private val user:String,
                           private val createur:String,
                           private val cont : Context)
{

    private val aDate : CArreraDate = CArreraDate()
    private val gText : CArreraGestionText = CArreraGestionText()
    private val gestionnaite : CGestionnaireNeuron = CGestionnaireNeuron(this.nameAssistant,this.but,this.vous,this.genre,this.user,this.createur,gText)
    private val nFormulation : CNeuronFormulation = CNeuronFormulation(gestionnaite,aDate);
    private val nChat : CNeuronChat = CNeuronChat(gestionnaite,nFormulation,gText);
    private val nTime : CNeuronTime = CNeuronTime(gestionnaite,aDate,gText)
    private val nInternet : CNeuronInternet = CNeuronInternet(cont,gText,gestionnaite)
    private val fMeteo: CfArreraMeteo = CfArreraMeteo();
    private val fActu : CfArreraActu = CfArreraActu()
    private val geo : Geocoder = Geocoder(cont)
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    fun neuron(requette :String, latitude:String, longitude:String, callback: (String) -> Unit)
    {
        var sortieNb = 0
        var sortieText = ""
        var genre = gestionnaite.genre
        var user = gestionnaite.user
        var etatvous = gestionnaite.etatVous
        var requetteFormater = gText.formatageText(requette)
        nChat.neuron(requetteFormater);
        sortieNb = nChat.outNeuronNb();
        if (sortieNb == 0 )
        {
            if (requetteFormater.contains("meteo"))
            {
                fMeteo.data(latitude,longitude,object : fMeteoSortie {
                    override fun onDataReceived(temperature: String, ville :String, description:String) {
                        if (etatvous)
                        {
                            sortieText = "La meteo a votre localisation est$description" + "avec une temperature de $temperature °C."
                            gestionnaite.setOldSortie(sortieText)
                            gestionnaite.setOldRequette(requetteFormater)
                            gestionnaite.addDiscution()
                            callback(sortieText)
                        }
                        else
                        {
                            sortieText =("La meteo a ta localisation est$description" + "avec une temperature de $temperature °C.")
                            gestionnaite.setOldSortie(sortieText)
                            gestionnaite.setOldRequette(requetteFormater)
                            gestionnaite.addDiscution()
                            callback(sortieText)
                        }
                    }

                    override fun onError(error: String) {
                        if (etatvous)
                        {
                            sortieText = "Desoler , "+genre+" "+user+" mais un probleme technique m'empeche de vous donnez la meteo. Ressayez plus tart"
                        }
                        else
                        {
                            sortieText = "Desoler , "+user+" mais je subit un probleme qui m'embeche de te donner la meteo. Ressaye plus tart"
                        }
                        gestionnaite.setOldSortie(sortieText)
                        gestionnaite.setOldRequette(requetteFormater)
                        gestionnaite.addDiscution()
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
                            gestionnaite.setOldRequette(requetteFormater)
                            gestionnaite.addDiscution()
                            callback(sortieText)
                    }

                        override fun onError(error: String) {
                            if (etatvous)
                            {
                                sortieText = "Desoler , "+genre+" "+user+" mais un probleme technique m'empeche de vous donnez les actualités. Ressayez plus tart"
                            }
                            else
                            {
                                sortieText = "Desoler , "+user+" mais je subit un probleme qui m'embeche de te donner les actualités. Ressaye plus tart"
                            }
                            gestionnaite.setOldSortie(sortieText)
                            gestionnaite.setOldRequette(requetteFormater)
                            gestionnaite.addDiscution()
                            callback(sortieText)
                        }
                    })
                }
                else
                {
                    nTime.neuron(requetteFormater)
                    sortieNb = nTime.outNeuronNb()
                    if (sortieNb==0)
                    {
                        if (requetteFormater.contains("ou je suis")||requetteFormater.contains("ou je me trouve")||requetteFormater.contains("on es ou"))

                        {
                            val adresse : String
                            geo.getFromLocation(latitude.toDouble(), longitude.toDouble(), 1,
                                GeocodeListener{ addresses ->
                                    val adresse = addresses[0].getAddressLine(0)
                                    callback("On se trouve au "+adresse)
                                })
                        }
                        else
                        {
                            if (requetteFormater.contains("temperature"))
                            {
                                fMeteo.data(latitude,longitude,object : fMeteoSortie {
                                    override fun onDataReceived(temperature: String, ville :String, description:String)
                                    {
                                            if (etatvous)
                                            {
                                                sortieText = "La temperature actuel a votre localisation est de $temperature °C."
                                                gestionnaite.setOldSortie(sortieText)
                                                gestionnaite.setOldRequette(requetteFormater)
                                                gestionnaite.addDiscution()
                                                callback(sortieText)
                                            }
                                            else
                                            {
                                                sortieText =("La temperature $temperature °C.")
                                                gestionnaite.setOldSortie(sortieText)
                                                gestionnaite.setOldRequette(requetteFormater)
                                                gestionnaite.addDiscution()
                                                callback(sortieText)
                                            }
                                        }
                                    override fun onError(error: String) {
                                        if (etatvous)
                                        {
                                            sortieText = "Desoler , "+genre+" "+user+" mais un probleme technique m'empeche de vous donnez la temperature. Ressayez plus tart"
                                        }
                                        else
                                        {
                                            sortieText = "Desoler , "+user+" mais je subit un probleme qui m'embeche de te donner la temperature. Ressaye plus tart"
                                        }
                                        gestionnaite.setOldSortie(sortieText)
                                        gestionnaite.setOldRequette(requetteFormater)
                                        gestionnaite.addDiscution()
                                        callback(sortieText)
                                    }
                                })
                            }
                            else
                            {
                                nInternet.neuron(requetteFormater)
                                sortieNb = nInternet.outNeuronNb()
                                if (sortieNb==0)
                                {
                                    sortieText = (nFormulation.nocomprehension());
                                    gestionnaite.setOldSortie(sortieText)
                                    gestionnaite.setOldRequette(requetteFormater)
                                    gestionnaite.addDiscution()
                                    callback(sortieText)
                                }
                                else
                                {
                                    sortieText = nInternet.outNeuronText()
                                    gestionnaite.setOldSortie(sortieText)
                                    gestionnaite.setOldRequette(requetteFormater)
                                    gestionnaite.addDiscution()
                                    callback(sortieText)
                                }
                            }
                        }

                    }
                    else
                    {
                        sortieText =(nTime.outNeuronText());
                        gestionnaite.setOldSortie(sortieText)
                        gestionnaite.setOldRequette(requetteFormater)
                        gestionnaite.addDiscution()
                        callback(sortieText)
                    }
                }

            }
        }
        else
        {
            sortieText = (nChat.outNeuronText())
            gestionnaite.setOldSortie(sortieText)
            gestionnaite.setOldRequette(requetteFormater)
            gestionnaite.addDiscution()
            callback(sortieText)
        }
    }

    fun bonjour():String
    {
        var sortie = nFormulation.salutation()
        gestionnaite.setOldRequette("boot")
        gestionnaite.setOldSortie(sortie)
        return sortie
    }

    fun aurevoir():String
    {
        gestionnaite.setOldSortie("au revoir")
        return nFormulation.aurevoir()
    }
}