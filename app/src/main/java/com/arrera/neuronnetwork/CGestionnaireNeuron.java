package com.arrera.neuronnetwork;

public class CGestionnaireNeuron {
    private String nameAssistant, but, genre, user;
    private boolean vous;

    public CGestionnaireNeuron(String nameAssistant, String but, Boolean vous, String genre, String user) {
        this.nameAssistant = nameAssistant;
        this.but = but;
        this.vous = vous;

        this.user = user;
        this.genre = genre;
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

}
