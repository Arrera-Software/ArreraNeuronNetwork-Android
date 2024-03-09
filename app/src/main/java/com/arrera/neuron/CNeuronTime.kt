package com.arrera.neuron

class CNeuronTime(private val gestionnaire : CGestionnaireNeuron,
                  private val aDate : CArreraDate,
                  private val gestText :CArreraGestionText)
{

    private var sortietext : String = ""
    fun neuron(requette:String)
    {
        if (requette.contains("date")||requette.contains("jour"))
        {
            sortietext = "On est le "+aDate.date+"."
        }
        else
        {
            if (requette.contains("heure"))
            {
                sortietext = "Il est "+aDate.hour+" heure "+aDate.min
            }
            else
            {
                sortietext = ""
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