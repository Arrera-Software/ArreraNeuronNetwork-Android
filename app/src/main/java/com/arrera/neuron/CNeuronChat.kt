package com.arrera.neuron

import kotlin.random.Random

class CNeuronChat(private val gestionnaire : CGestionnaireNeuron ,
                  private val nFormulation: CNeuronFormulation ,
                  private val gest : CArreraGestionText)
{
    private var sortieText : String = "" ;
    //private var sortieNb : Int = 0 ;
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

    private var listFonction = listOf(
        "ouvrir une application",
        "aider sur les recherches de internet",
        "donner la meteo",
        "donner les actualites")

    fun neuron(requette :String)
    {
        var oldSortie = gestionnaire.oldSortie
        var oldRequette = gestionnaire.oldrequette
        var genre = gestionnaire.genre
        var user = gestionnaire.user
        var etatVous = gestionnaire.etatVous
        var bute = gestionnaire.but
        var name = gestionnaire.nameAssistant
        var createur = gestionnaire.createur
        var nbDiscution = gestionnaire.nbDiscution
        if (requette.contains("bonjour")||requette.contains("salut")||requette.contains("coucou")||requette.contains("bonsoir"))
        {
            this.sortieText = nFormulation.salutation();
        }
        else {
            if (requette.contains("au revoir")||requette.contains("a bientot")||requette.contains("a plus tart")||requette.contains("bye")||requette.contains("quitter")||requette.contains("arret")||requette.contains("arreter")){
                this.sortieText = nFormulation.aurevoir();
            }
            else
            {
                if (requette.contains("raconter une blague")||requette.contains("raconte moi une blague")||requette.contains("raconte une blague"))
                {
                    if (oldRequette.contains("vous etes pas drole")||oldRequette.contains("tu es pas drole")||oldRequette.contains("c'est pas drole")||oldRequette.contains("pas drole"))
                    {
                        this.sortieText = "Je peux pas raconter un blague si je suis pas drole."
                    }
                    else
                    {
                        var nRand =  Random.nextInt(0,8)
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
                        }
                    }
                    else {
                        if(oldSortie.contains("Avant de dire sa , laisse t'en raconter une")||oldSortie.contains("Avant de dire sa , laissez-vous en raconter une"))
                        {
                            if (requette.contains("non")||requette.contains("pas besoin"))
                            {
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
                                }
                            }
                            else
                            {
                                if (requette.contains("comment ca va ") || requette.contains( "ca va") ||
                                    requette.contains( "ca va" ) || requette.contains( "comment vas tu" ) ||
                                    requette.contains("comment allez vous" ) || requette.contains( "tu vas bien" ) ||
                                    requette.contains( "vous allez bien" ) || requette.contains( "est ce que tout va bien") ||
                                    requette.contains("tout va bien pour toi") || requette.contains("tout va bien pour vous"))
                                {
                                    var nbRand = Random.nextInt(0, 1)
                                    var listReponse = listOf("Je suis un programme informatique je resent pas de sentiment.",
                                            "Je ne peut pas resentir de sentiment, je suis qu'un programmme informatique.")
                                    sortieText = listReponse[nbRand]
                                }
                                else
                                {
                                    if (requette.contains("tu peux me parler de toi") || requette.contains("tu peux te presenter") || requette.contains("presente toi")) {
                                        if (oldRequette.contains("tu es qui") ||oldRequette.contains("présente toi") || oldRequette.contains("présentation") ||
                                            oldRequette.contains("qui es tu") ||oldRequette.contains("qui es tu")) {

                                            if(etatVous) {
                                                sortieText = "Je vous l'ai deja dit " + genre + " je peux pas trop vous dire plus je n'est pas de passion ni de hobbie je ne suis qu'un programme informatique qui a pour bute " + bute + "."
                                            }
                                            else {
                                                sortieText = "Je te l'ai deja dit " + user + " je peux pas trop t'en dire plus je n'est pas de passion ni de hobbie je ne suis qu'un programme informatique qui a pour bute " + bute + "."
                                            }
                                        }
                                        else
                                        {
                                            sortieText = "Je suis un assistant personnelle nommer " + name + " qui a été crée par " + createur + ". Je n'ai pas pas de passion ni de hobbie du a ma conditions de programme informatique."
                                        }
                                    }
                                    else {
                                        if ( requette.contains("tu es qui") || requette.contains("présente toi")
                                            || requette.contains("présentation") || requette.contains("qui es tu")
                                            || requette.contains("qui es tu"))
                                        {
                                            var finPhrase :String
                                            var debutPhrase:String
                                            if (nbDiscution >= 5)
                                            {
                                                finPhrase = "Vous me parler depuis un moment sans savoir qui je suis ?"
                                            }
                                            else
                                                {
                                                    finPhrase = ""
                                                }
                                            if (name == "SIX") {
                                                debutPhrase = "Je suis Six , l'assistant personnelle Vocal de " + genre + " " + user + " " + ". Crée par Baptiste Pauchet pour simplifier et automatiser l'uttilisation de son ordinateur et pour le divertire."
                                            }
                                            else {
                                                if (name == "Ryley") {
                                                    debutPhrase = "Je suis Ryley un assistant textuel crée a l'origine par Baptiste Pauchet et Wiruto2 .Pour les assister dans leurs etude et par la suite les aider dans le developement informatique."
                                                }
                                                else {
                                                    debutPhrase = "Je suis " + name + " crée par " + createur + ". Qui a pour bute " + bute + ". Et qui utilise un algorythme d'assistant personnelle developper par Arrera Software."
                                                }
                                            }
                                            sortieText = debutPhrase + finPhrase
                                        }
                                        else
                                        {
                                            if (requette.contains("toujours la") || requette.contains("es tu la" )
                                            || requette.contains(name.lowercase()) || requette.contains("tu es la")
                                            || requette.contains("vous étes la") || requette.contains("vous etes la"))
                                            {
                                                var nbRand = Random.nextInt(0, 2)
                                                var listReponse = listOf("Je ne peut pas partir de tout façon .",
                                                        "Je ne pas partir tant que je peux servir .",
                                                        "A moin de m'arréter qui serait un acte horible je suis toujour la .")
                                                if (etatVous )
                                                {
                                                    this.sortieText = "Oui, je suis toujours la " + genre + " " + user + "." + listReponse[nbRand]
                                                }
                                                else
                                                {
                                                    this.sortieText = "Oui, je suis toujours la " + user + listReponse[nbRand]
                                                }
                                            }
                                            else
                                            {
                                                if (requette.contains("quesque tu peux faire")||requette.contains("tu peux faire quoi")||requette.contains("tu peux faire quoi"))
                                                {
                                                    var nblist = listFonction.size
                                                    var text = ""
                                                    var tampons = ""
                                                    for (i in 0 until nblist)
                                                    {
                                                        tampons = text
                                                        if (i==nblist-1)
                                                        {
                                                            text = tampons+ " et "+listFonction[i]
                                                        }
                                                        else
                                                        {
                                                            if (i==0){
                                                                text = listFonction[i]
                                                            }
                                                            else
                                                            {
                                                                text = tampons +","+listFonction[i]
                                                            }

                                                        }
                                                    }
                                                    if (etatVous)
                                                    {
                                                        sortieText = "Je peux vous aidez a "+text
                                                    }
                                                    else
                                                    {
                                                        sortieText = "Je peux t'aidez a "+text
                                                    }
                                                }
                                                if ((oldRequette=="boot")&&(requette.contains("oui")||
                                                            requette.contains("non")||requette.contains("bien")))
                                                {
                                                    if(requette.contains("oui"))
                                                    {
                                                        if (oldSortie.contains("J'espère que vous avez un peu dormi.")) {
                                                            var nbRand = Random.nextInt(0, 1)
                                                            var listReponse = listOf(
                                                                "Tant mieux dit moi si vous avez besoin de moi",
                                                                "Je suis content de savoir sa")
                                                            this.sortieText = listReponse[nbRand] + " " + genre + " ."
                                                        }
                                                        else
                                                        {
                                                            if (oldSortie.contains("Êtes-vous prêt à travailler ?")) {
                                                                var nbRand = Random.nextInt(0, 1)
                                                                var listReponse = listOf("Okay je peux vous aider sur quoi " + genre,
                                                                    "Super sur quoi vous voulez travailler")
                                                                this.sortieText = listReponse[nbRand] + " ."

                                                            }
                                                            else
                                                            {
                                                                if (oldSortie.contains("J'espère que vous avez passé une bonne nuit.")) {
                                                                    this.sortieText = "Super sur quoi vous voulez travailler " + genre + " ."
                                                                }
                                                                else
                                                                {
                                                                    if (oldSortie.contains("J'espère que vous passez une bonne matinée.")) {
                                                                        this.sortieText = "Formidable sur quoi vous occupez votre début de matinée"
                                                                    }
                                                                    else
                                                                    {
                                                                        if (oldSortie.contains("J'espère que vous passez un bon début de journée.")) {
                                                                            this.sortieText = "Formidable, vous travaillez sur quoi ?"
                                                                        }
                                                                        else
                                                                        {
                                                                            if (oldSortie.contains("J'espère que vous passez une bonne après-midi ?")) {
                                                                                this.sortieText = "Formidable que fais-vous de votre après-midi ."
                                                                            }
                                                                            else
                                                                            {
                                                                                if (oldSortie.contains("Comment se passe votre début de soirée ?")) {
                                                                                    this.sortieText = "Ceci me réjouit genre vous voulez faire quoi " + genre + " ."
                                                                                }
                                                                                else
                                                                                {
                                                                                    if (oldSortie.contains("J'espère que votre début de soirée se passe bien.")) {
                                                                                        this.sortieText = "Formidable vous voulez faire quoi ce soir ."
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        if (oldSortie.contains("Comment se passe votre soirée ?")) {
                                                                                            this.sortieText = "Parfais je peux vous aidez ce soir " + genre
                                                                                        }
                                                                                        else
                                                                                        {
                                                                                            if (oldSortie.contains("J'espère que votre soirée s'est bien passée.")) {
                                                                                                this.sortieText = "Ok vous vouliez faire quoi cette nuit ."
                                                                                            }
                                                                                            else {
                                                                                                if (oldSortie.contains("As-tu bien dormi ?")) {
                                                                                                    this.sortieText = "C'est surper pour toi ."
                                                                                                }
                                                                                                else
                                                                                                {
                                                                                                    if (oldSortie.contains("As-tu passé une bonne nuit ?")) {
                                                                                                        this.sortieText = "Tant mieux pour toi tu veux travailler sur quoi aujourd'hui ."
                                                                                                    }
                                                                                                    else
                                                                                                    {
                                                                                                        if (oldSortie.contains("Comment se passe ta matinée ?")) {
                                                                                                            this.sortieText = "Parfais sur quoi on travaille aujourd'hui  ."
                                                                                                        }
                                                                                                        else
                                                                                                        {
                                                                                                            if (oldSortie.contains("Prêt à travailler ?")) {
                                                                                                                this.sortieText = "Ok on travaille sur quoi aujourd'hui ."
                                                                                                            }
                                                                                                            else
                                                                                                            {
                                                                                                                if (oldSortie.contains("es-tu prêt à travailler cet après-midi ?")) {
                                                                                                                    this.sortieText = "Ok on travaille sur quoi cette aprem ."
                                                                                                                } else {
                                                                                                                    this.sortieText = "";
                                                                                                            }
                                                                                                        }
                                                                                                    }

                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                    else
                                                    {
                                                        if (requette.contains("non"))
                                                        {
                                                            if (oldSortie.contains("J'espère que vous avez un peu dormi"))
                                                            {
                                                                var nbRand = Random.nextInt(0,1)
                                                                var listReponse = listOf("Je suis désolé pour vous je suis la pour vous aidez si vous a besoin "+genre,
                                                                    "Vous dormirez mieux ce soir en attendant en quoi je peux vous aider")
                                                                this.sortieText = listReponse[nbRand]+" ."
                                                            }
                                                            else
                                                            {
                                                                if (oldSortie.contains("Êtes-vous prêt à travailler ?"))
                                                                {
                                                                    var nbRand = Random.nextInt(0,1)
                                                                    var listReponse = listOf("Okay, vous voulez faire quoi",
                                                                        "OK je reste disponible pour vous "+genre)
                                                                    this.sortieText = listReponse[nbRand]+" ."
                                                                }
                                                                else
                                                                {
                                                                    if (oldSortie.contains("J'espère que vous avez passé une bonne nuit."))
                                                                    {
                                                                        this.sortieText = "Dommage je reste disponible si vous avez besoin de moi "
                                                                    }
                                                                    else
                                                                    {
                                                                        if (oldSortie.contains("J'espère que vous avez bien dormi."))
                                                                        {
                                                                            this.sortieText = "Dommage si vous avez besoin de moi je suis la ."
                                                                        }
                                                                        else
                                                                        {
                                                                            if (oldSortie.contains("J'espère que vous passez une bonne matinée."))
                                                                            {
                                                                                this.sortieText = "OK je suis à votre service si vous avez besoin de moi ."

                                                                            }
                                                                            else
                                                                            {
                                                                                if (oldSortie.contains("J'espère que vous passez un bon début de journée."))
                                                                                {
                                                                                    this.sortieText = "Dommage comment je peux vous la rendre meilleure "+genre+"."
                                                                                }
                                                                                else
                                                                                {
                                                                                    if (oldSortie.contains("J'espère que vous passez une bonne après-midi ?"))
                                                                                    {
                                                                                        this.sortieText = "Ha, je reste la si vous avez besoin de moi je suis la ."
                                                                                    }
                                                                                    else
                                                                                    {
                                                                                        if (oldSortie.contains("Comment se passe votre début de soirée ?")) {
                                                                                            this.sortieText = "Comment je peux la rendre meilleur " + genre
                                                                                        }
                                                                                        else
                                                                                        {
                                                                                            if (oldSortie.contains("J'espère que votre début de soirée se passe bien."))
                                                                                            {
                                                                                                this.sortieText = "Comment je peux rendre votre soirée exceptionnelle ."
                                                                                            }
                                                                                            else {
                                                                                                if (oldSortie.contains("Comment se passe votre soirée ?")) {
                                                                                                    this.sortieText = "Ceci me rend triste ."
                                                                                                }
                                                                                                else
                                                                                                {
                                                                                                    if (oldSortie.contains("J'espère que votre soirée s'est bien passée."))
                                                                                                    {
                                                                                                        this.sortieText = "Je vous conseiller d'allez dormir ."
                                                                                                    }
                                                                                                    else
                                                                                                    {
                                                                                                        if (oldSortie.contains("As-tu bien dormi ?"))
                                                                                                        {
                                                                                                            this.sortieText = "Dommage je peux d'aidez sur quoi ?"
                                                                                                        }
                                                                                                        else
                                                                                                        {
                                                                                                            if (oldSortie.contains("As-tu passé une bonne nuit ?"))
                                                                                                            {
                                                                                                                this.sortieText = "Dommage comment je peux t'aider aujourd'hui ?"
                                                                                                            }
                                                                                                            else
                                                                                                            {
                                                                                                                if (oldSortie.contains("Prêt à travailler ?"))
                                                                                                                {
                                                                                                                    this.sortieText = "Ok je reste la au besoin ."
                                                                                                                }
                                                                                                                else
                                                                                                                {
                                                                                                                    if (oldSortie.contains("Es-tu prêt à travailler cet après-midi ?"))
                                                                                                                    {
                                                                                                                        this.sortieText = "Ok dit moi quand tu sera prét ."
                                                                                                                    }
                                                                                                                    else
                                                                                                                    {
                                                                                                                        this.sortieText = ""
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        else
                                                        {
                                                            if (requette.contains("bien"))
                                                            {
                                                                if (oldSortie.contains("Comment se passe votre début de soirée ?"))
                                                                {
                                                                    this.sortieText = "Ceci me réjouit "+genre+" que vous voulez faire ce soir ?"
                                                                }
                                                                else
                                                                {
                                                                    if (oldSortie.contains("Comment se passe votre soirée ?"))
                                                                    {
                                                                        this.sortieText = "Parfais en quoi je vous aidez ce soir "+genre+" ?"
                                                                    }
                                                                    else
                                                                    {
                                                                        if (oldSortie.contains("Comment se passe ta matinée ?"))
                                                                        {
                                                                            this.sortieText = "Parfais sur quoi on travaille aujourd'hui ?"

                                                                        }
                                                                        else
                                                                        {
                                                                            this.sortieText = "";
                                                                        }

                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                else {
                                                    if (requette.contains("quesque tu peux faire")||requette.contains("tu peux faire quoi")||requette.contains("tu peux faire quoi"))
                                                    {
                                                        var nblist = listFonction.size
                                                        var text = ""
                                                        var tampons = ""
                                                        for (i in 0 until nblist)
                                                        {
                                                            tampons = text
                                                            if (i == nblist - 1)
                                                            {
                                                                text = tampons + " et " + listFonction[i]
                                                            } else
                                                            {
                                                                if (i == 0) {
                                                                    text = listFonction[i]
                                                                } else {
                                                                    text = tampons + "," + listFonction[i]
                                                                }

                                                            }
                                                        }
                                                        if (etatVous)
                                                        {
                                                            sortieText = "Je peux vous aidez a " + text
                                                        } else
                                                        {
                                                            sortieText = "Je peux t'aidez a " + text
                                                        }

                                                    }
                                                    else
                                                    {
                                                        if (requette.contains("oui"))
                                                        {
                                                            this.sortieText = "OK parfais .";
                                                        }
                                                        else{
                                                            if (requette.contains("non"))
                                                            {
                                                               if (etatVous)
                                                               {
                                                                   this.sortieText = "OK "+genre+" "+user+ " je reste la au besoin.";
                                                               }
                                                               else
                                                               {
                                                                   this.sortieText = "Ok "+user+" ,Je reste la si tu a besoin de moi."
                                                               }
                                                            }
                                                            else
                                                            {
                                                                if (requette.contains("merci"))
                                                                {
                                                                    if (etatVous)
                                                                    {
                                                                        this.sortieText = "De rien "+genre+",je reste a votre servie si vous avez besoin de moi ?";
                                                                    }
                                                                    else
                                                                    {
                                                                        this.sortieText = "De rien "+user+",sur quoi je peux encore t'aider ?";
                                                                    }
                                                                }
                                                                else
                                                                {
                                                                    if (requette.contains("ta gueule")||requette.contains("tais toi"))
                                                                    {
                                                                        if (etatVous)
                                                                        {
                                                                            this.sortieText = "Ok "+genre+" je me tais";
                                                                        }
                                                                        else
                                                                        {
                                                                            this.sortieText = "Ok";
                                                                        }
                                                                    }
                                                                    else
                                                                    {
                                                                        this.sortieText = "";
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
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
        return gest.testOut(sortieText)
    }
}