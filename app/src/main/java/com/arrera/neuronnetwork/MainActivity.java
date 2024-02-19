package com.arrera.neuronnetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CArreraNeuronNetwork arreraNetwork = new CArreraNeuronNetwork("Opale","Developper un algo d'assistant pour android",true,"monsieur","dev") ;
        // Recuperation des widget
        TextView textSortie = findViewById(R.id.IDC_SORTIE);

        //Programme de test
        textSortie.setText(arreraNetwork.salutation());
    }
}