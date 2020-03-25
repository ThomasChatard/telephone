package com.example.tacheroulette;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Resume extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resume);

        final Button hasard = findViewById(R.id.hasard);
        hasard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(Resume.this, RoueHasardPersonnes.class);
                Resume.this.startActivity(intent);
            }
        });
    }
}