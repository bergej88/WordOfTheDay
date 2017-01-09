package com.drunkcollegeapps.jeff.wordoftheday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class TestLandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_landing);

        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString = null;
            } else {
                newString = (String) extras.getString("word");
            }
        } else {
            newString = (String) savedInstanceState.getSerializable("word");
        }

        String word = "You selected " +
        String.valueOf(newString);
        Toast.makeText(TestLandingActivity.this, word, Toast.LENGTH_LONG).show();


    }








}
