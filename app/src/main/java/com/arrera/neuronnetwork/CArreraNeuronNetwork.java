package com.arrera.neuronnetwork;



public class CArreraNeuronNetwork {

    private String oldRequette , oldSortie;
    private CArreraDate date;
    private int valeurSortieNeuron ;
    private CGestionnaireNeuron gestionnaireNeuron ;
    private CNeuronFormulation nFormulation;
    private  fncArreraNeuron fNeuron;


    public CArreraNeuronNetwork(String nameAssistant, String but, Boolean vous, String genre, String user) {
        this.gestionnaireNeuron = new CGestionnaireNeuron(nameAssistant,but,vous,genre,user);
        this.fNeuron = new fncArreraNeuron(this.gestionnaireNeuron);
        this.date = new CArreraDate();
        this.nFormulation = new CNeuronFormulation(this.gestionnaireNeuron,this.date);
    }

    public String booting()
    {
        String text = this.nFormulation.salutation();
        this.oldRequette = "boot";
        this.oldSortie =  text;
        return text ;
    }
    public String shutdown(){
        String text = this.nFormulation.aurevoir();
        this.oldRequette = "shutdown";
        this.oldSortie =  text;
        return text ;
    }

    private int verifSortie(String sortie)
    {
        if (sortie.length()==0)
        {
            return 0 ;
        }
        else
        {
            return 1 ;
        }
    }
    public void neuron(String requette){
        String sortie;
        int nbSortie = 0 ;
        sortie = this.nFormulation.nocomprehension();
        this.oldRequette = requette;
        this.oldSortie = sortie ;
        this.valeurSortieNeuron = nbSortie;
    }

    public String getSortie (){
        return  this.oldSortie ;
    }

    public int getValeur(){
        return this.valeurSortieNeuron ;
    }




}
