package com.example.tacheroulette;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;
import rubikstudio.library.LuckyWheelView;
import rubikstudio.library.model.LuckyItem;


public class RoueHasard extends Activity {
    List<LuckyItem> data = new ArrayList<>();
    private int cpt = 0;
    private String btnStr;
    private ArrayList<String> noms = new ArrayList<String>();
    private ArrayList<String> taches = new ArrayList<String>();
    private ArrayList<String> resumeNoms = new ArrayList<String>();
    private ArrayList<String> resumeTaches = new ArrayList<String>();
    KonfettiView konfettiView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rouehasard);

        konfettiView = (KonfettiView) findViewById(R.id.viewKonfetti);

        Intent intent = getIntent();

        if (intent.hasExtra("noms")){
            noms = intent.getStringArrayListExtra("noms");
        }

        if (intent.hasExtra("taches")){
            taches = intent.getStringArrayListExtra("taches");
        }

        final TextView tv = findViewById(R.id.tv);
        tv.setText(taches.get(0));

        final ImageButton home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(RoueHasard.this, Menu.class);
                RoueHasard.this.startActivity(intent);
            }
        });

        final LuckyWheelView luckyWheelView = (LuckyWheelView) findViewById(R.id.luckyWheel);

        for(int i = 0; i < noms.size(); i++){
            LuckyItem luckyItem1 = new LuckyItem();
            luckyItem1.topText = noms.get(i);
            luckyItem1.color = 0xffFFF3E0;
            data.add(luckyItem1);
        }

        luckyWheelView.setData(data);
        luckyWheelView.setRound(5);

        final Button btn = findViewById(R.id.start);

        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnStr = btn.getText().toString();
                if (btnStr == "Voir résumé"){
                    Intent intent1 = new Intent(RoueHasard.this, Resume.class);
                    intent1.putExtra("resumeNoms", resumeNoms);
                    intent1.putExtra("resumeTaches", resumeTaches);
                    startActivity(intent1);
                }else{
                    int index = getRandomIndex();
                    luckyWheelView.startLuckyWheelWithTargetIndex(index);
                }
            }
        });

        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
            @Override
            public void LuckyRoundItemSelected(int index) {
                Toast.makeText(getApplicationContext(), data.get(index).topText, Toast.LENGTH_SHORT).show();
                resumeNoms.add(noms.get(index));
                resumeTaches.add(taches.get(cpt));
                cpt += 1;
                if (cpt == taches.size()){
                    btn.setText("Voir résumé");
                    tv.setText("");
                } else {
                    tv.setText(taches.get(cpt));
                }
                konfettiView.build()
                        .addColors(Color.YELLOW,Color.GREEN, Color.MAGENTA)
                        .setDirection(0.0,359.0)
                        .setSpeed(1f,5f)
                        .setFadeOutEnabled(true)
                        .setTimeToLive(2000L)
                        .addShapes(Shape.CIRCLE, Shape.RECT)
                        .addSizes(new Size(12,16))
                        .setPosition(konfettiView.getX()+konfettiView.getWidth()/2,konfettiView.getY()+konfettiView.getHeight()/3)
                        .burst(100);
            }
        });
    }

    private int getRandomIndex() {
        Random rand = new Random();
        return rand.nextInt(data.size());
    }

    private int getRandomRound() {
        Random rand = new Random();
        return rand.nextInt(10) + 15;
    }
}
