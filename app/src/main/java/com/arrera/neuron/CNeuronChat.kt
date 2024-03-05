package com.arrera.neuron

class CNeuronChat(private val gestionnaire : CGestionnaireNeuron , private val nFormulation: CNeuronFormulation)
{
    private var sortieText : String = "" ;
    private var sortieNb : Int = 0 ;
    private var oldSortie = gestionnaire.oldSortie ;
    fun neuron(requette :String)
    {
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
                this.sortieNb = 0 ;
                this.sortieText = "";
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