package com.arrera.neuron;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CNeuronFormulation {
    private String nameAssistant, genre, user;
    private boolean vous;
    private CArreraDate date;

    public CNeuronFormulation(CGestionnaireNeuron gestion,CArreraDate date ){
        this.nameAssistant = gestion.getNameAssistant();
        this.genre = gestion.getGenre();
        this.user = gestion.getUser();
        this.vous = gestion.getEtatVous();
        this.date =  date;
    }
    public String salutation() {
        Random random = new Random();
        String sortie, formule, cmp;
        List<String> phrase = new ArrayList<>();
        int hour = date.getHour();
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
        } else {
            if ((hour >= 3) && (hour < 6)) {
                if (this.vous == true) {
                    formule = "Bonjour,";
                    cmp = this.genre + " " + this.user;
                    phrase.add("Êtes-vous prêt à travailler ?");
                    phrase.add("");
                } else {
                    formule = "Zzzz";
                    cmp = this.user;
                    phrase.add("Il faudrait peut-être dormir, non ?");
                    phrase.add("Comment peux-tu travailler si tard ?");
                }
            } else {
                if ((hour >= 6) && (hour < 10)) {
                    if (this.vous == true) {
                        formule = "Bonjour, ";
                        cmp = this.genre + " " + this.user;
                        phrase.add("J'espère que vous avez passé une bonne nuit.");
                        phrase.add("J'espère que vous avez bien dormi.");
                    } else {
                        formule = "Hey,";
                        cmp = this.user;
                        phrase.add("As-tu bien dormi ?");
                        phrase.add("As-tu passé une bonne nuit ?");
                    }
                } else {
                    if ((hour >= 10) && (hour < 12)) {
                        if (this.vous == true) {
                            formule = "Bonjour, ";
                            cmp = this.genre + " " + this.user;
                            phrase.add("J'espère que vous passez une bonne matinée.");
                            phrase.add("J'espère que vous passez un bon début de journée.");
                        } else {
                            formule = "Salut,";
                            cmp = this.user;
                            phrase.add("Comment se passe ta matinée ?");
                            phrase.add("Que fais-tu de beau ce matin ?");
                        }
                    } else {
                        if ((hour >= 13) && (hour < 14)) {
                            if (this.vous == true) {
                                formule = "Bonjour,";
                                cmp = this.genre + " " + this.user;
                                phrase.add("J'espère que vous passez une bonne après-midi ?");
                                phrase.add("");
                            } else {
                                formule = "Alors";
                                cmp = this.user;
                                phrase.add("Prêt à travailler ?");
                                phrase.add("Es-tu prêt à travailler cet après-midi ?");
                            }
                        }
                        if ((hour >= 15) && (hour < 18)) {
                            if (this.vous == true) {
                                formule = "Bonjour,";
                                cmp = this.genre + " " + this.user;
                                phrase.add("Sur quoi puis-je vous aider cet après-midi ?");
                                phrase.add("Comment puis-je vous aider ?");
                            } else {
                                formule = "Salut,";
                                cmp = this.user;
                                phrase.add("Sur quoi travailles-tu ?");
                                phrase.add("En quoi puis-je t'aider ?");
                            }
                        }
                        if ((hour >= 18) && (hour < 20)) {
                            if (this.vous == true) {
                                formule = "Bonsoir,";
                                cmp = this.genre + " " + this.user;
                                phrase.add("Comment se passe votre début de soirée ?");
                                phrase.add("J'espère que votre début de soirée se passe bien.");
                            } else {
                                formule = "Alors";
                                cmp = this.user;
                                phrase.add("Que veux-tu faire ce soir ?");
                                phrase.add("Veux-tu travailler ou te divertir ce soir ?");
                            }
                        } else {
                            if ((hour >= 20) && (hour < 23)) {
                                if (this.vous == true) {
                                    formule = "Bonsoir,";
                                    cmp = this.genre + " " + this.user;
                                    phrase.add("Comment se passe votre soirée ?");
                                    phrase.add("J'espère que votre soirée s'est bien passée.");
                                } else {
                                    formule = "*bâille*";
                                    cmp = this.user;
                                    phrase.add("Que fais-tu si tard ?");
                                    phrase.add("Pourquoi me réveilles-tu si tard ?");
                                }
                            } else {
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
                                } else {
                                    if (this.vous == true) {
                                        formule = "Bonjour,";
                                        cmp = this.genre + " " + this.user;
                                        phrase.add("Que voulez-vous qu'on fasse ?");
                                        phrase.add("");
                                    } else {
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
        return formule+" "+cmp+". "+phrase.get(random.nextInt(2));
    }

    public String aurevoir() {
        Random random = new Random();
        String sortie, formule, cmp;
        List<String> phrase = new ArrayList<>();
        int hour = date.getHour();
        if ((hour >= 0) && (hour < 3)) {
            if (this.vous == true) {
                formule = "Bonne nuit,";
                cmp = this.genre + " " + this.user;
                phrase.add("Reposez-vous bien.");
                phrase.add("Passez une bonne nuit.");
            } else {
                formule = "Au revoir,";
                cmp = this.user;
                phrase.add("Bonne nuit.");
                phrase.add("Bonne nuit, repose-toi bien.");
            }
        } else {
            if ((hour >= 3) && (hour <= 6)) {
                if (this.vous == true) {
                    formule = "Bonne nuit,";
                    cmp = this.genre + " " + this.user;
                    phrase.add("Essayez de vous reposer.");
                    phrase.add("Reposez-vous bien.");
                } else {
                    formule = "Bonne nuit,";
                    cmp = this.user;
                    phrase.add("Essaie de te reposer un peu.");
                    phrase.add("Repose-toi un peu.");
                }
            } else {
                if ((hour >= 6) && (hour <= 10)) {
                    if (this.vous == true) {
                        formule = "Bonne journée,";
                        cmp = this.genre + " " + this.user;
                        phrase.add("Passez une bonne journée.");
                        phrase.add("Profitez bien de votre journée.");
                    } else {
                        formule = "Au revoir,";
                        cmp = this.user;
                        phrase.add("Passe une bonne journée.");
                        phrase.add("Profite bien de ta journée.");
                    }
                } else {
                    if ((hour >= 10) && (hour <= 12)) {
                        if (this.vous == true) {
                            formule = "Au revoir,";
                            cmp = this.genre + " " + this.user;
                            phrase.add("Passez une bonne fin de matinée.");
                            phrase.add("Profitez bien de votre fin de matinée.");
                        } else {
                            formule = "Au revoir,";
                            cmp = this.user;
                            phrase.add("Passe une bonne fin de matinée.");
                            phrase.add("Profite bien de ta fin de matinée.");
                        }
                    } else {
                        if ((hour >= 13) && (hour <= 14)) {
                            if (this.vous == true) {
                                formule = "Bonne après-midi,";
                                cmp = this.genre + " " + this.user;
                                phrase.add("Profitez bien.");
                                phrase.add("");
                            } else {
                                formule = "Bonne après-midi,";
                                cmp = this.user;
                                phrase.add("");
                                phrase.add("Profite bien.");
                            }
                        } else {
                            if ((hour >= 15) && (hour <= 18)) {
                                if (this.vous == true) {
                                    formule = "Au revoir,";
                                    cmp = this.genre + " " + this.user;
                                    phrase.add("Passez une bonne fin d'après-midi.");
                                    phrase.add("Profitez bien de votre fin de soirée.");
                                } else {
                                    formule = "Au revoir,";
                                    cmp = this.user;
                                    phrase.add("Profite bien de ta fin d'après-midi.");
                                    phrase.add("");
                                }
                            } else {
                                if ((hour >= 18) && (hour <= 20)) {
                                    if (this.vous == true) {
                                        formule = "Bonne soirée,";
                                        cmp = this.genre + " " + this.user;
                                        phrase.add("Profitez bien ");
                                        phrase.add("Reposez-vous bien ce soir.");
                                    } else {
                                        formule = "Au revoir,";
                                        cmp = this.user;
                                        phrase.add("Profite bien de ta soirée.");
                                        phrase.add("Repose-toi bien ce soir.");
                                    }
                                } else {
                                    if ((hour >= 20) && (hour <= 23)) {
                                        if (this.vous == true) {
                                            formule = "Bonne nuit,";
                                            cmp = this.genre + " " + this.user;
                                            phrase.add("Dormez bien.");
                                            phrase.add("Reposez-vous bien.");
                                        } else {
                                            formule = "Bonne nuit,";
                                            cmp = this.user;
                                            phrase.add("Dors bien.");
                                            phrase.add("Repose-toi bien.");
                                        }
                                    } else {
                                        if ((hour >= 0) && (hour < 3)) {
                                            if (this.vous == true) {
                                                formule = "Bonne nuit,";
                                                cmp = this.genre + " " + this.user;
                                                phrase.add("Dormez bien, soyez en forme pour demain.");
                                                phrase.add("Reposez-vous bien pour demain.");
                                            } else {
                                                formule = "Bonne nuit,";
                                                cmp = this.user;
                                                phrase.add("Dors bien, sois en forme pour demain.");
                                                phrase.add("Repose-toi bien pour demain.");
                                            }
                                        } else {
                                            if (this.vous == true) {
                                                formule = "Au revoir,";
                                                cmp = this.genre + " " + this.user;
                                                phrase.add("J'espère vous revoir bientôt.");
                                                phrase.add("");
                                            } else {
                                                formule = "Au revoir,";
                                                cmp = this.user;
                                                phrase.add("J'espère te revoir bientôt.");
                                                phrase.add("");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return formule+" "+cmp+" "+ phrase.get(random.nextInt(2));
    }

    public String nocomprehension() {
        String text ;
        if (this.vous == true) {
            text = "Je ne comprend pas ce que vous m'avez dit.";
        }
        else {
            text = "Je ne comprend pas ce que tu m'as dit ou ce que tu demande.";
        }
        return text;
    }
}