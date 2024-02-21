package com.arrera.neuronnetwork;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.net.Uri;

public class fncNArreraSearch {

    boolean etatConnection ;
    public fncNArreraSearch (boolean etatConnextion)
    {
        this.etatConnection = etatConnextion ;
    }

    public boolean duckduckgoSearch (String recherche)
    {
        if (this.etatConnection == true)
        {
            String url = "https://duckduckgo.com/?q=" ;
            String lien = url+recherche;
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(lien));
            startActivity(intent);
            return true ;
        }
        else {
            return false ;
        }
    }
}
