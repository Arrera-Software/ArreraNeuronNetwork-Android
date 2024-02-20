package com.arrera.neuronnetwork;



public class CArreraNeuronNetwork {
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
        return this.nFormulation.salutation();
    }
    public String shutdown(){
        return this.nFormulation.aurevoir();
    }

    public String neuron(String requette){
        String sortie;
        sortie = this.nFormulation.nocomprehension();
        return sortie;
    }

}
