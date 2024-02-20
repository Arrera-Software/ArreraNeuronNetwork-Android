package com.arrera.neuronnetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CArreraNeuronNetwork arreraNetwork = new CArreraNeuronNetwork("Opale","Developper un algo d'assistant pour android",true,"monsieur","dev") ;
        // Recuperation des widget
        TextView textSortie = findViewById(R.id.IDC_SORTIE);
        Button btnQUIT = findViewById(R.id.IDC_QUIT);

        //Programme de test
        //textSortie.setText(Integer.toString(new CArreraDate().getHour()));
        textSortie.setText(arreraNetwork.salutation());

        btnQUIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSortie.setText(arreraNetwork.aurevoir());
                //finish();
            }
        });
    }
}