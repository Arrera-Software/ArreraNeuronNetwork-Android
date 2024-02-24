package com.arrera.neuronnetwork;



public class CArreraNeuronNetwork {

    private String oldRequette , oldSortie;
    private CArreraDate date;
    private int valeurSortieNeuron ;
    private CGestionnaireNeuron gestionnaireNeuron ;
    private CNeuronFormulation nFormulation;
    private  fncArreraNeuron fNeuron;

    private CNeuronService nService ;


    public CArreraNeuronNetwork(String nameAssistant, String but, Boolean vous, String genre, String user) {
        this.gestionnaireNeuron = new CGestionnaireNeuron(nameAssistant,but,vous,genre,user);
        this.fNeuron = new fncArreraNeuron(this.gestionnaireNeuron);
        this.date = new CArreraDate();
        this.nFormulation = new CNeuronFormulation(this.gestionnaireNeuron,this.date);

        //Neuron
        this.nService = new CNeuronService(this.gestionnaireNeuron,this.date);
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
        String texte ,requetteFormate;
        this.oldRequette = requette;
        requetteFormate = this.fNeuron.formateText(requette);
        int nbSortie = 0 ;
        nService.neuron(requetteFormate);
        nbSortie = nService.getValeurSortie() ;
        if (nbSortie==0) {
            texte = this.nFormulation.nocomprehension();
        }
        else
        {
            texte = this.nService.getText();
        }
        this.oldSortie = texte ;
        this.valeurSortieNeuron = nbSortie;
    }

    public String getSortie (){
        return  this.oldSortie ;
    }

    public int getValeur(){
        return this.valeurSortieNeuron ;
    }




}
