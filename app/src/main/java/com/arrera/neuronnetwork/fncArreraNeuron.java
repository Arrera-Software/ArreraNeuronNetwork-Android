package com.arrera.neuronnetwork;
import com.arrera.neuronnetwork.fncNArreraSearch ;

public class fncArreraNeuron {
    CGestionnaireNeuron gestionnaite ;
    fncNArreraSearch  recherche ;
    public fncArreraNeuron(CGestionnaireNeuron gestionnaite)
    {
        this.gestionnaite = gestionnaite ;
        this.recherche = new fncNArreraSearch(true);
    }

    public String sortieRecherche(String requete)
    {
        boolean etatVous = this.gestionnaite.getEtatVous();
        if (etatVous == true){
            requete = requete.replace("search", "");
            requete = requete.replace("recherche", "");
            recherche.duckduckgoSearch(requete);
            return "Voici votre recherche";
        }
        else{
            return "aa";
        }
    }
}
