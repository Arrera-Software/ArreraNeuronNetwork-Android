package com.arrera.neuron

import kotlin.random.Random

class CNeuronChat(private val gestionnaire : CGestionnaireNeuron , private val nFormulation: CNeuronFormulation)
{
    private var sortieText : String = "" ;
    private var sortieNb : Int = 0 ;
    private var blagues = listOf(
        "Que dit une noisette quand elle tombe dans l’eau ?",
        "Comment est-ce que les abeilles communiquent entre elles ?",
        "Quel est l’arbre préféré du chômeur ?",
        "Qu’est-ce qu’une frite enceinte ?",
        "Que dit une mère à son fils geek quand le dîner est servi ?",
        "Qu’est-ce qui est mieux que gagner une médaille d’or aux Jeux Paralympiques ?",
        "Pourquoi les Ch’tis aiment les fins de vacances au camping ?",
        "Quelle est la partie de la voiture la plus dangereuse ?",
        "Pourquoi dit-on que les poissons travaillent illégalement ?",
        "Mettre du sirop dans son gel douche"
    )

    private var reponsesBlagues = listOf(
        "Je me noix.",
        "Par-miel.",
        "Le bouleau.",
        "Une patate sautée.",
        "Alt Tab !",
        "Marcher",
        "Parce que c’est le moment où ils peuvent démonter leur tente.",
        "La conductrice.",
        "Parce qu'ils n'ont pas de FISH de paie",
        "En fait, dans tous les gels douches. Qu’une fois dans la salle de bain il n’y ait aucune issue possible."
    )

    fun neuron(requette :String)
    {
        var oldSortie = gestionnaire.oldSortie
        var oldRequette = gestionnaire.oldrequette
        var genre = gestionnaire.genre
        var user = gestionnaire.user
        var etatVous = gestionnaire.etatVous
        if (requette.contains("bonjour")||requette.contains("salut")||requette.contains("coucou")||requette.contains("bonsoir"))
        {
            this.sortieNb = 1 ;
            this.sortieText = nFormulation.salutation();
        }
        else {
            if (requette.contains("au revoir")||requette.contains("a bientot")||requette.contains("a plus tart")||requette.contains("bye")||requette.contains("quitter")||requette.contains("arret")||requette.contains("arreter")){
                this.sortieNb = 15;
                this.sortieText = nFormulation.aurevoir();
            }
            else
            {
                if (requette.contains("raconter une blague")||requette.contains("raconte moi une blague")||requette.contains("raconte une blague"))
                {
                    if (oldRequette.contains("vous etes pas drole")||oldRequette.contains("tu es pas drole")||oldRequette.contains("c'est pas drole")||oldRequette.contains("pas drole"))
                    {
                        this.sortieNb = 1
                        this.sortieText = "Je peux pas raconter un blague si je suis pas drole."
                    }
                    else
                    {
                        var nRand =  Random.nextInt(0,8)
                        this.sortieNb = 1
                        this.sortieText = this.blagues[nRand]+" "+this.reponsesBlagues[nRand]
                    }
                }
                else
                {
                    if (requette.contains("vous etes pas drole") || requette.contains("tu es pas drole") || requette.contains("c'est pas drole") || requette.contains("pas drole")) {
                        if (oldRequette.contains("raconter une blague")||oldRequette.contains("raconte moi une blague")||oldRequette.contains("raconte une blague"))
                        {
                            var nbRand = Random.nextInt(0,2)
                            var listVous = listOf ("Désoler de ne pas etre drole pour vous "+genre+" .",
                                "Désoler si je ne suis pas drole "+genre+" .",
                                "Je peux vous en racontez une autre.")
                            var listTU =  listOf("Désoler de ne pas etre drole pour toi "+user+" .",
                                "Désoler si je ne suis pas drole "+user+" .",
                                "Je peux t'en raconter une autre.")
                            if (etatVous)
                            {
                                sortieText = listVous[nbRand]
                            }
                            else
                            {
                                sortieText = listTU[nbRand]
                            }
                            sortieNb = 1

                        }
                        else
                        {
                            var nbRand = Random.nextInt(0,1)
                            var listVous = listOf ("Pourquoi vous dites sa je ne vous es meme pas racompter une blague.",
                                "Avant de dire sa , laissez-vous en raconter une.")
                            var listTU =  listOf("Pourquoi tu dit sa je ne t'en ai meme pas raconter une.",
                                "Avant de dire sa , laisse t'en raconter une.")
                            if (etatVous)
                            {
                                sortieText = listVous[nbRand]
                            }
                            else
                            {
                                sortieText = listTU[nbRand]
                            }
                            sortieNb = 1
                        }
                    }
                    else {
                        if(oldSortie.contains("Avant de dire sa , laisse t'en raconter une")||oldSortie.contains("Avant de dire sa , laissez-vous en raconter une"))
                        {
                            if (requette.contains("non")||requette.contains("pas besoin"))
                            {
                                this.sortieNb = 1
                                var nbRand = Random.nextInt(0,1)
                                var listReponse1 = listOf("Ok commme vous voulez "+genre+" .",
                                    "Etes-vous vraiment sur "+genre+" .")
                                var listReponse2 = listOf("Ok comme tu veux "+user+" .",
                                    "Es-tu vraiment sure de toi "+user+" .")
                                if (etatVous) {
                                    this.sortieText = listReponse1[nbRand]
                                }
                                else {
                                    this.sortieText = listReponse2[nbRand]
                                }
                            }
                            else
                            {
                                if (requette.contains("oui")||requette.contains("vasy")||requette.contains("comme tu veux")||requette.contains("si vous voulez"))
                                {
                                    var nRand =  Random.nextInt(0,8)
                                    this.sortieNb = 1
                                    if (etatVous)
                                    {
                                        this.sortieText = "Ok "+genre+"je vous en raconte une. "+this.blagues[nRand]+" "+this.reponsesBlagues[nRand]
                                    }
                                    else
                                    {
                                        this.sortieText = "Ok "+user+"je t'en raconte une. "+this.blagues[nRand]+" "+this.reponsesBlagues[nRand]
                                    }
                                }
                            }
                        }
                        else
                        {
                            if (requette.contains("Je peux vous en racontez une autre") || requette.contains("Je peux t'en raconter une autre") || requette.contains("Si tu veux je peux t'en raconter une autre") )
                            {
                                if (requette.contains("vasy") || requette.contains("comme tu veux") || requette.contains("si vous voulez"))
                                {
                                    var nRand = Random.nextInt(0, 8)
                                    if( etatVous ) {
                                        this.sortieText = "Ok " + genre + " en voici une autre . " + this.blagues[nRand]+" "+this.reponsesBlagues[nRand] + " ."
                                    }
                                    else {
                                        this.sortieText = "Ok " + user + " en voici une autre . " + this.blagues[nRand] + " " + this.reponsesBlagues[nRand] + " ."
                                    }
                                    this.sortieNb = 1
                                }
                            }
                            else
                            {
                                this.sortieNb = 0;
                                this.sortieText = "";
                            }

                        }
                    }
                }
            }
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
}