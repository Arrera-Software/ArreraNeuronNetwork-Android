package com.arrera.neuronnetwork;

public class CNeuronService
{
    CGestionnaireNeuron gestionnaire ;
    CArreraDate date;
    private String sortie ;
    private int valeurSortie ;
    public CNeuronService(CGestionnaireNeuron gestion,CArreraDate date) {
        this.gestionnaire = gestion ;
        this.date = date;
    }
    public void neuron (String requette)
    {
        this.sortie = "";
        this.valeurSortie = 0 ;
        String user = this.gestionnaire.getUser() ,genre=this.gestionnaire.getGenre();
        boolean vous = this.gestionnaire.getEtatVous();
        if ((requette.contains("donne"))&&(requette.contains("date")))
        {
            this.sortie = "La date du jour est "+this.date.getDate();
            this.valeurSortie = 1 ;
        }
    }

    public int getValeurSortie(){
        return this.valeurSortie;
    }

    public String getText()
    {
        return this.sortie;
    }
}
