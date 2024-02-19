package com.arrera.neuronnetwork;

import java.util.ArrayList;
import java.util.List;

public class CArreraNeuronNetwork {
    private  String nameAssistant,but ,genre,user ;
    private boolean vous ;
    private CArreraDate date ;

    public CArreraNeuronNetwork(String nameAssistant,String but,Boolean vous,String genre,String user)
    {
        this.nameAssistant = nameAssistant ;
        this.but = but ;
        this.vous = vous;
        this.date = new CArreraDate() ;
        this.user = user;
        this.genre = genre ;
    }


    public String salutation()
    {
        String sortie,formule,cmp ;
        List<String> phrase = new ArrayList<>();
        int hour = date.getHour();
        if ((hour >= 0 )&&(hour < 3 ))
        {
            if (this.vous == true)
            {
                formule = "Bonjour," ;
                cmp = this.genre + " " + this.user ;
                phrase.add("Que faites-vous si tôt ?");
                phrase.add("J'espère que vous avez un peu dormi.");
            }
            else
            {
                formule = "Zzzz" ;
                cmp = this.user ;
                phrase.add("Il faudrait peut-être dormir, non ?");
                phrase.add("Comment peux-tu travailler si tard ?");
            }
        }
        return "sortie ";
    }
}
