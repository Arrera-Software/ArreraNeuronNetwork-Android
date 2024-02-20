package com.arrera.neuronnetwork;



public class CArreraNeuronNetwork {
    private CArreraDate date;
    private CGestionnaireNeuron gestionnaireNeuron ;
    private CNeuronFormulation nFormatation ;

    public CArreraNeuronNetwork(String nameAssistant, String but, Boolean vous, String genre, String user) {
        this.gestionnaireNeuron = new CGestionnaireNeuron(nameAssistant,but,vous,genre,user);
        this.date = new CArreraDate();
        this.nFormatation = new CNeuronFormulation(this.gestionnaireNeuron,this.date);

    }

    public String booting()
    {
        return this.nFormatation.salutation();
    }
    public String shutdown(){
        return this.nFormatation.aurevoir();
    }

    public String neuron(String requette){
        return requette;
    }

}
