package com.example.tacheroulette;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        final Button hasard = findViewById(R.id.hasard);
        hasard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(Menu.this, RoueHasardPersonnes.class);
                Menu.this.startActivity(intent);
            }
        });

        final ImageButton parametres = findViewById(R.id.parametres);
        parametres.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(Menu.this, Parametres.class);
                Menu.this.startActivity(intent);
            }
        });
    }
}
