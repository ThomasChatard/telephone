package com.bluehomestudio.luckywheeldemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RoueHasard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rouehasard);

        final ImageButton retour = findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(RoueHasard.this, RoueHasardPersonnes.class);
                RoueHasard.this.startActivity(intent);
            }
        });
    }
}
