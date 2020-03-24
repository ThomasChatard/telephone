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
        String[] str = new String[500];
        if (intent.hasExtra("noms")){
            str = intent.getStringArrayExtra("noms");
        }

        final TextView tv = findViewById(R.id.tv);
        tv.setText(str[0]);

        final Button suivant = findViewById(R.id.suivant);
        final String[] finalStr = str;
        suivant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(RoueHasardTaches.this, RoueHasard.class);
                intent.putExtra("noms", finalStr);
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
