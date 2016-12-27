package com.drunkcollegeapps.jeff.wordoftheday;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] tempWords = {"Pith", "Obstreperous", "Acrimonious", "Mercurial", "Defenestration"
                , "Bifurcate"};

        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                tempWords);

        ListView theListView = (ListView) findViewById(R.id.lvWordFeed);

        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String word = "You selected " +

                String.valueOf(adapterView.getItemAtPosition(i));

                Toast.makeText(MainActivity.this, word, Toast.LENGTH_SHORT).show();

            }
        });


    }
}
