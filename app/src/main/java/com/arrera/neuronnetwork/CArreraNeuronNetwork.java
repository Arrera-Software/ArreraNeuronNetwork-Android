package com.arrera.neuronnetwork;



public class CArreraNeuronNetwork {

    private String oldRequette , oldSortie;
    private CArreraDate date;
    private CGestionnaireNeuron gestionnaireNeuron ;
    private CNeuronFormulation nFormulation;

    public CArreraNeuronNetwork(String nameAssistant, String but, Boolean vous, String genre, String user) {
        this.gestionnaireNeuron = new CGestionnaireNeuron(nameAssistant,but,vous,genre,user);
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

    public String neuron(String requette){
        String sortie;
        sortie = this.nFormulation.nocomprehension();
        this.oldRequette = requette;
        this.oldSortie =  sortie;
        return sortie;
    }

}
