package com.drunkcollegeapps.jeff.wordoftheday;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TestLandingActivity extends AppCompatActivity {

    TextView tvTest;

    // -- Firebase Authentication -- //
    private FirebaseAuth.AuthStateListener mAuthListener;
    private GoogleApiClient mGoogleApiClient;
    private FirebaseUser currentUser;

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

        TextView textViewToChange = (TextView) findViewById(R.id.tvInspectedWord);
        textViewToChange.setText(newString);


        // -- Initialize Views -- //
        tvTest = (TextView) findViewById(R.id.tvTestInfo);

        // -- Initialize Firebase -- //
        // Get the current user using the global Application reference
        currentUser = WOTDApplication.getInstance().mAuth.getCurrentUser();

        // A default auth state listener (allows us to do something in the event the user logs out)
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // Use this block to handle when a user disconnects
                }
            }
        };

        // -- Testing Methods -- //
        tvTest.setText(currentUser.getDisplayName());
    }


}
