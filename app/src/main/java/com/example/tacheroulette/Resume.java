package com.example.tacheroulette;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class Resume extends Activity {

    private ArrayList<String> resumeNoms = new ArrayList<String>();
    private ArrayList<String> resumeTaches = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resume);

        //On recupere le résumé
        Intent intent = getIntent();

        if (intent.hasExtra("resumeNoms")){
            resumeNoms = intent.getStringArrayListExtra("resumeNoms");
        }

        if (intent.hasExtra("resumeTaches")){
            resumeTaches = intent.getStringArrayListExtra("resumeTaches");
        }

        ListView ListViewTaches = (ListView) findViewById(R.id.lv);
        ListView ListViewNoms = (ListView) findViewById(R.id.lv1);

        final ArrayAdapter<String> adapterNoms = new ArrayAdapter(this, android.R.layout.simple_list_item_1, resumeNoms);
        ListViewNoms.setAdapter(adapterNoms);

        final ArrayAdapter<String> adapterTaches = new ArrayAdapter(this, android.R.layout.simple_list_item_1, resumeTaches);
        ListViewTaches.setAdapter(adapterTaches);
    }
}