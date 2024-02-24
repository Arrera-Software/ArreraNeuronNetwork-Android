package com.arrera.neuronnetwork;

public class fncArreraNeuron {
    CGestionnaireNeuron gestionnaite ;
    public fncArreraNeuron(CGestionnaireNeuron gestionnaite)
    {
        this.gestionnaite = gestionnaite ;
    }

    public String formateText (String var)
    {
        return var.toLowerCase().replace("é","e").replace("è","e").replace("à","a");
    }

}
