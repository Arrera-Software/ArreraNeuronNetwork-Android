package com.arrera.neuronnetwork;

public class CNeuronSearch {

    CGestionnaireNeuron gestionnaire ;
    fncArreraNeuron fonctionArrera ;
    private String sortie ;
    private int valeurSortie ;
    public CNeuronSearch(CGestionnaireNeuron gestion,fncArreraNeuron fonctionArrera) {

        this.gestionnaire = gestion ;
        this.fonctionArrera = fonctionArrera ;
    }
    public void neuron (String requete)
    {

        String user = this.gestionnaire.getUser() ,genre=this.gestionnaire.getGenre();
        boolean vous = this.gestionnaire.getEtatVous();
        if (requete.contains("search")) {
            this.sortie = fonctionArrera.sortieRecherche(requete);
        } else if (requete.contains("recherche")) {
            this.sortie = fonctionArrera.sortieRecherche(requete);
        } else {
            this.sortie = "";
            this.valeurSortie = 0;
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
