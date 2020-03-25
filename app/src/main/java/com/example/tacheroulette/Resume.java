package com.example.tacheroulette;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class Resume extends Activity {

    private String[] tabnoms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resume);

        //On recupere le résumé
        Intent intent = getIntent();

        if (intent.hasExtra("resumeNom")){
            tabnoms = intent.getStringArrayExtra("resumeNom");
        }
        String[] tabtache = new String[100];
        if (intent.hasExtra("resumeTache")){
            tabtache = intent.getStringArrayExtra("resumeTache");
        }
        int position = 0;
        while (tabnoms[position] != null){
            position = position + 1;
        }
        final TextView tv2 = (TextView) findViewById(R.id.textView2);
        tv2.setText(tabnoms[0]);
        ListView mListView = (ListView) findViewById(R.id.lv);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tabnoms);
        mListView.setAdapter(adapter);
    }
}