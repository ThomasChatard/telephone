package com.example.tacheroulette;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RoueHasardTaches extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rouehasardtaches);
        Intent intent = getIntent();
        final String[] stringArray = intent.getStringArrayExtra("noms");
        final TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(stringArray[0]);


        final Button suivant = findViewById(R.id.suivant);
        suivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent1 = new Intent(RoueHasardTaches.this, RoueHasard.class);
                intent1.putExtra("noms",stringArray);
                startActivity(intent1);
            }
        });

        final ImageButton retour = findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent2 = new Intent(RoueHasardTaches.this, RoueHasardPersonnes.class);
                RoueHasardTaches.this.startActivity(intent2);
            }
        });
    }
}
