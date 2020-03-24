package com.example.tacheroulette;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class RoueHasardPersonnes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rouehasardpersonnes);

        final Button suivant = findViewById(R.id.suivant);
        final Button ajouter = findViewById(R.id.ajouter);
        final ArrayList<String> noms = new ArrayList<String>();
        final String[] array = new String[500];

        ajouter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final EditText saisie = (EditText) findViewById(R.id.et1);
                noms.add(saisie.getText().toString());
                saisie.setText(" ");
            }
        });
        suivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                for (int i = 0; i <= noms.size()-1; i++){
                    array[i] = noms.get(i);
                }
                Intent intent = new Intent(RoueHasardPersonnes.this, RoueHasardTaches.class);
                intent.putExtra("noms",array);
                startActivity(intent);
            }
        });

        final ImageButton home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(RoueHasardPersonnes.this, Menu.class);
                RoueHasardPersonnes.this.startActivity(intent);
            }
        });
    }
}
