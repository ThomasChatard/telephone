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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rouehasard);

        Intent intent = getIntent();
        String[] str = new String[500];
        if (intent.hasExtra("noms")){
            str = intent.getStringArrayExtra("noms");
        }

        int position = 0;
        while (str[position] != null){
            position = position + 1;
        }

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
            luckyItem1.topText = str[i];
            luckyItem1.color = 0xffFFF3E0;
            data.add(luckyItem1);
        }

        /*
        LuckyItem luckyItem2 = new LuckyItem();
        luckyItem2.topText = "200";
        luckyItem2.color = 0xffFFE0B2;
        data.add(luckyItem2);

        LuckyItem luckyItem3 = new LuckyItem();
        luckyItem3.topText = "300";
        luckyItem3.color = 0xffFFCC80;
        data.add(luckyItem3);

        //////////////////
        LuckyItem luckyItem4 = new LuckyItem();
        luckyItem4.topText = "400";
        luckyItem4.color = 0xffFFF3E0;
        data.add(luckyItem4);

        LuckyItem luckyItem5 = new LuckyItem();
        luckyItem5.topText = "500";
        luckyItem5.color = 0xffFFE0B2;
        data.add(luckyItem5);

        LuckyItem luckyItem6 = new LuckyItem();
        luckyItem6.topText = "600";
        luckyItem6.color = 0xffFFCC80;
        data.add(luckyItem6);
        //////////////////

        //////////////////////
        LuckyItem luckyItem7 = new LuckyItem();
        luckyItem7.topText = "700";
        luckyItem7.color = 0xffFFF3E0;
        data.add(luckyItem7);

        LuckyItem luckyItem8 = new LuckyItem();
        luckyItem8.topText = "800";
        luckyItem8.color = 0xffFFE0B2;
        data.add(luckyItem8);


        LuckyItem luckyItem9 = new LuckyItem();
        luckyItem9.topText = "900";
        luckyItem9.color = 0xffFFCC80;
        data.add(luckyItem9);
        ////////////////////////

        LuckyItem luckyItem10 = new LuckyItem();
        luckyItem10.topText = "1000";
        luckyItem10.color = 0xffFFE0B2;
        data.add(luckyItem10);

        LuckyItem luckyItem11 = new LuckyItem();
        luckyItem11.topText = "2000";
        luckyItem11.color = 0xffFFE0B2;
        data.add(luckyItem11);

        LuckyItem luckyItem12 = new LuckyItem();
        luckyItem12.topText = "3000";
        luckyItem12.color = 0xffFFE0B2;
        data.add(luckyItem12);

        /////////////////////

         */

        luckyWheelView.setData(data);
        luckyWheelView.setRound(5);

        /*luckyWheelView.setLuckyWheelBackgrouldColor(0xff0000ff);
        luckyWheelView.setLuckyWheelTextColor(0xffcc0000);
        luckyWheelView.setLuckyWheelCenterImage(getResources().getDrawable(R.drawable.icon));
        luckyWheelView.setLuckyWheelCursorImage(R.drawable.ic_cursor);*/


        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = getRandomIndex();
                luckyWheelView.startLuckyWheelWithTargetIndex(index);
            }
        });

        luckyWheelView.setLuckyRoundItemSelectedListener(new LuckyWheelView.LuckyRoundItemSelectedListener() {
            @Override
            public void LuckyRoundItemSelected(int index) {
                Toast.makeText(getApplicationContext(), data.get(index).topText, Toast.LENGTH_SHORT).show();
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
