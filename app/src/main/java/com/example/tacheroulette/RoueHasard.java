package com.example.tacheroulette;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import rubikstudio.library.LuckyWheelView;
import rubikstudio.library.model.LuckyItem;
import rubikstudio.library.PielView;

public class RoueHasard extends Activity {
    List<LuckyItem> data = new ArrayList<>();
    private int cpt = 0;
    private String[] tabnoms = new String[500];
    private String[] resumeNom = new String[100];
    private String[] finalTabtaches = new String[100];
    private String btnStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rouehasard);
        //On récupère les noms
        Intent intent = getIntent();

        if (intent.hasExtra("noms")){
            tabnoms = intent.getStringArrayExtra("noms");
        }
        int position = 0;
        while (tabnoms[position] != null){
            position = position + 1;
        }

        //On récupère les taches
        String[] tabtaches = new String[500];
        if (intent.hasExtra("noms")){
            tabtaches = intent.getStringArrayExtra("taches");
        }
        final TextView tv = findViewById(R.id.tv);
        tv.setText(tabtaches[0]);

        final TextView tv1 = (TextView) findViewById(R.id.textView);




        final ImageButton home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(RoueHasard.this, Menu.class);
                RoueHasard.this.startActivity(intent);
            }
        });

        final LuckyWheelView luckyWheelView = (LuckyWheelView) findViewById(R.id.luckyWheel);

        for(int i = 0; i < position; i++){
            LuckyItem luckyItem1 = new LuckyItem();
            luckyItem1.topText = tabnoms[i];
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
                    intent1.putExtra("resumeNom", resumeNom);
                    intent1.putExtra("resumeTache", finalTabtaches);
                    startActivity(intent1);
                }else{
                    int index = getRandomIndex();
                    luckyWheelView.startLuckyWheelWithTargetIndex(index);
                }
            }
        });

        finalTabtaches = tabtaches;

        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
            @Override
            public void LuckyRoundItemSelected(int index) {
                Toast.makeText(getApplicationContext(), data.get(index).topText, Toast.LENGTH_SHORT).show();
                tv.setText(finalTabtaches[cpt +1]);
                tv1.setText(tabnoms[index]);
                resumeNom[cpt] = tabnoms[index];
                cpt = cpt + 1;
                if (finalTabtaches[cpt] == null){
                    btn.setText("Voir résumé");
                }
            }
        });
    }

    private int getRandomIndex() {
        Random rand = new Random();
        return rand.nextInt(data.size()) + 0;
    }

    private int getRandomRound() {
        Random rand = new Random();
        return rand.nextInt(10) + 15;
    }
}
