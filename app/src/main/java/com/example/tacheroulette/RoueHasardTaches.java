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

public class RoueHasardTaches extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rouehasardtaches);

        Intent intent = getIntent();
        String[] str = new String[500];
        if (intent.hasExtra("noms")){
            str = intent.getStringArrayExtra("noms");
        }

        final Button suivant = findViewById(R.id.suivant);
        final Button ajouter = findViewById(R.id.ajouter);
        final ArrayList<String> taches = new ArrayList<String>();
        final String[] array = new String[500];

        ajouter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final EditText saisie = (EditText) findViewById(R.id.et1);
                taches.add(saisie.getText().toString());
                saisie.setText(" ");
            }
        });

        final String[] finalStr = str;
        suivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                for (int i = 0; i <= taches.size()-1; i++){
                    array[i] = taches.get(i);
                }
                Intent intent = new Intent(RoueHasardTaches.this, RoueHasard.class);
                intent.putExtra("noms", finalStr);
                intent.putExtra("taches", array);
                RoueHasardTaches.this.startActivity(intent);
            }
        });

        final ImageButton home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(RoueHasardTaches.this, Menu.class);
                RoueHasardTaches.this.startActivity(intent);
            }
        });
    }
}
