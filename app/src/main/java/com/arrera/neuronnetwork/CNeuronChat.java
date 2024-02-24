package com.arrera.neuronnetwork;

public class CNeuronChat {
    CGestionnaireNeuron gestionnaire ;
    CNeuronFormulation formule;
    private String sortie ;
    private int valeurSortie ;
    public CNeuronChat(CGestionnaireNeuron gestion,CNeuronFormulation formule) {
        this.gestionnaire = gestion ;
        this.formule = formule;
    }
    public void neuron (String requette)
    {
        if (requette.contains("bonjour")||requette.contains("salut")||requette.contains("coucou")||requette.contains("bonsoir")){
            this.valeurSortie = 1;
            this.sortie = formule.salutation();
        }
        else {
            if (requette.contains("au revoir")||requette.contains("a bientot")||requette.contains("a plus tart")||requette.contains("bye")||requette.contains("quitter")||requette.contains("arret")||requette.contains("arreter")){
                this.valeurSortie = 15;
                this.sortie = formule.aurevoir();
            }
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
