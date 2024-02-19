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
        else
        {
            if ((hour >= 3 )&&(hour < 6 ))
            {
                if (this.vous == true)
                {
                    formule = "Bonjour,";
                    cmp = this.genre + " " + this.user ;
                    phrase.add("Êtes-vous prêt à travailler ?");
                    phrase.add("");
                }
                else
                {
                    formule = "Zzzz";
                    cmp = this.user;
                    phrase.add("Il faudrait peut-être dormir, non ?");
                    phrase.add("Comment peux-tu travailler si tard ?");
                }
            }
            else
            {
                if ((hour >= 6) && (hour <= 10))
                {
                    if (this.vous==true) {
                        formule = "Bonjour, ";
                        cmp = this.genre + " " + this.user;
                        phrase.add("J'espère que vous avez passé une bonne nuit.");
                        phrase.add("J'espère que vous avez bien dormi.");
                    }
                    else
                    {
                        formule = "Hey,";
                        cmp = this.user;
                        phrase.add("As-tu bien dormi ?");
                        phrase.add("As-tu passé une bonne nuit ?");
                    }
                }
                else
                {
                    if ((hour>=10)&&(hour<=12))
                    {
                        if (this.vous==true) {
                            formule = "Bonjour, ";
                            cmp = this.genre + " " + this.user ;
                            phrase.add("J'espère que vous passez une bonne matinée.");
                            phrase.add("J'espère que vous passez un bon début de journée.");
                        }
                        else {
                            formule = "Salut,";
                            cmp = this.user;
                            phrase.add("Comment se passe ta matinée ?");
                            phrase.add("Que fais-tu de beau ce matin ?");
                        }
                    }
                    else
                    {
                        if ((hour >= 13) && (hour <= 14)) {
                            if (this.vous == true) {
                                formule = "Bonjour,";
                                cmp = this.genre + " " + this.user;
                                phrase.add("J'espère que vous passez une bonne après-midi ?");
                                phrase.add("");
                            }
                            else {
                                formule = "Alors";
                                cmp = this.user;
                                phrase.add("Prêt à travailler ?");
                                phrase.add("Es-tu prêt à travailler cet après-midi ?");
                            }
                        }
                        if ((hour >= 15) && (hour <= 18)) {
                            if (this.vous == true) {
                                formule = "Bonjour,";
                                cmp = this.genre + " " + this.user;
                                phrase.add("Sur quoi puis-je vous aider cet après-midi ?");
                                phrase.add("Comment puis-je vous aider ?");
                            }
                            else {
                                formule = "Salut,";
                                cmp = this.user;
                                phrase.add("Sur quoi travailles-tu ?");
                                phrase.add("En quoi puis-je t'aider ?");
                            }
                        }
                        if ((hour >= 18) && (hour <= 20)) {
                            if (this.vous==true) {
                                formule = "Bonsoir,";
                                cmp = this.genre + " " + this.user;
                                phrase.add("Comment se passe votre début de soirée ?");
                                phrase.add("J'espère que votre début de soirée se passe bien.");
                            }
                            else {
                                formule = "Alors";
                                cmp = this.user;
                                phrase.add("Que veux-tu faire ce soir ?");
                                phrase.add("Veux-tu travailler ou te divertir ce soir ?");
                            }
                        }
                        else
                        {
                            if ((hour >= 20) && (hour <= 23))
                            {
                                if (this.vous == true)
                                {
                                    formule = "Bonsoir,";
                                    cmp = this.genre + " " + this.user;
                                    phrase.add("Comment se passe votre soirée ?");
                                    phrase.add("J'espère que votre soirée s'est bien passée.");
                                }
                                else
                                {
                                    formule = "*bâille*";
                                    cmp = this.user;
                                    phrase.add("Que fais-tu si tard ?");
                                    phrase.add("Pourquoi me réveilles-tu si tard ?");
                                }
                            }
                            else
                            {
                                if ((hour >= 0) && (hour < 3)) {
                                    if (this.vous == true) {
                                        formule = "Bonjour,";
                                        cmp = this.genre + " " + this.user;
                                        phrase.add("Que faites-vous si tôt ?");
                                        phrase.add("J'espère que vous avez un peu dormi.");
                                    } else {
                                        formule = "Zzzz";
                                        cmp = this.user;
                                        phrase.add("Il faudrait peut-être dormir, non ?");
                                        phrase.add("Comment peux-tu travailler si tard ?");
                                    }
                                }
                                    else
                                    {
                                        if (this.vous == true) {
                                            formule = "Bonjour,";
                                            cmp = this.genre + " " + this.user;
                                            phrase.add("Que voulez-vous qu'on fasse ?");
                                            phrase.add("");
                                        }
                                        else {
                                            formule = "Salut,";
                                            cmp = this.user;
                                            phrase.add("Que veux-tu que je t'aide à faire ?");
                                            phrase.add("");
                                        }
                                    }
                            }
                        }
                    }
                }

            }
        }
        return formule+cmp+phrase.get(0);
    }
}
