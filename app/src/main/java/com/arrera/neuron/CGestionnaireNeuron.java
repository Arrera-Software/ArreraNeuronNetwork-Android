package com.arrera.neuron;

public class CGestionnaireNeuron {
    private String nameAssistant, but, genre, user,createur;
    private CArreraGestionText gText ;
    private boolean vous;
    private String oldSortie = "";

    private String oldRequette = "";
    private int nbDiscution ;

    public CGestionnaireNeuron(String nameAssistant, String but, Boolean vous, String genre, String user,String createur,CArreraGestionText gText) {
        this.nameAssistant = nameAssistant;
        this.but = but;
        this.vous = vous;
        this.user = user;
        this.genre = genre;
        this.createur = createur;
        this.nbDiscution = 0;
        this.gText = gText;
    }

    public String getNameAssistant() {
        return this.nameAssistant;
    }
    public String getBut(){
        return  this.but ;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getUser(){
        return this.user;
    }

    public boolean getEtatVous()
    {
        return  this.vous;
    }

    public String getCreateur(){return this.createur;}

    public int getNbDiscution(){return this.nbDiscution;}

    public void addDiscution(){nbDiscution=nbDiscution+1;}

    public boolean setOldSortie(String sortie)
    {
        if (sortie.isEmpty())
        {
            return  false ;
        }
        else
        {
            this.oldSortie = gText.formatageText(sortie);
            return  true ;
        }
    }

    public String getOldSortie()
    {
        return this.oldSortie;
    }

    public boolean setOldRequette(String requette)
    {
        if (requette.isEmpty())
        {
            return false;
        }
        else
        {
            this.oldRequette = gText.formatageText(requette);
            return  true;
        }
    }

    public String getOldrequette()
    {
        return this.oldRequette ;
    }
}