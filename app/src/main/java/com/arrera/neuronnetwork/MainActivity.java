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
        Button btnSend = findViewById(R.id.IDC_BTNSEND);
        TextView textIN = findViewById(R.id.IDC_SEND);

        //Programme de test
        //textSortie.setText(Integer.toString(new CArreraDate().getHour()));
        textSortie.setText("Opale : "+arreraNetwork.booting());

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valeur ;
                arreraNetwork.neuron(textIN.getText().toString());
                valeur = arreraNetwork.getValeur();
                textSortie.setText("Opale : "+arreraNetwork.getSortie() );
                textIN.setText("");

            }
        });

    }
}