package com.arrera.neuronnetwork;

public class CNeuronService
{
    CGestionnaireNeuron gestionnaire ;
    private String sortie ;
    private int valeurSortie ;
    public CNeuronService(CGestionnaireNeuron gestion) {
        this.gestionnaire = gestion ;
    }
    public void neuron ()
    {
        this.sortie = "";
        this.valeurSortie = 0 ;
        String user = this.gestionnaire.getUser() ,genre=this.gestionnaire.getGenre();
        boolean vous = this.gestionnaire.getEtatVous();
    }

    public int getValeurSortie(){
        return this.valeurSortie;
    }

    public String getText()
    {
        return this.sortie;
    }
}
