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
        ArrayList<String> noms = new ArrayList<String>();
        if (intent.hasExtra("noms")){
            noms = intent.getStringArrayListExtra("noms");
        }

        final Button suivant = findViewById(R.id.suivant);
        final Button ajouter = findViewById(R.id.ajouter);
        final ArrayList<String> taches = new ArrayList<String>();

        ajouter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                final EditText saisie = (EditText) findViewById(R.id.et1);
                taches.add(saisie.getText().toString());
                saisie.setText(" ");
            }
        });

        final ArrayList<String> finalNoms = noms;
        suivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(RoueHasardTaches.this, RoueHasard.class);
                intent.putExtra("noms", finalNoms);
                intent.putExtra("taches", taches);
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
