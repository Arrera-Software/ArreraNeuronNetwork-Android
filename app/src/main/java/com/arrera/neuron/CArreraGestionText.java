package com.arrera.neuron;

public class CArreraGestionText {
    public String formatageText(String requette)
    {
        String sortie = requette.replace("é","e")
                .replace("è","e")
                .replace("à","a")
                .replace("ç","c")
                .replace("â","a")
                .replace("ê","e")
                .toLowerCase();
        return sortie;
    }
}
