package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WonActivity extends AppCompatActivity {

    private TextView score, corectQ, wrongQ;
    private Button done;

    private BottomNavigationView bottomNavigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            overridePendingTransition(0, 0);
                            return true;
                        case R.id.nav_account:
                            startActivity(new Intent(getApplicationContext(), MyProfileActivity.class));
                            overridePendingTransition(0, 0);
                            return true;
                        case R.id.nav_logout:
                            return true;
                    }
                    return false;
                }
            };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        bottomNavigationView= findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        score = findViewById(R.id.score);
        done = findViewById(R.id.done);
        corectQ = findViewById(R.id.correctQ);
        wrongQ = findViewById(R.id.wrongQ);

        String score_str = getIntent().getStringExtra("score_points");
        score.setText(score_str);

        String score_final = getIntent().getStringExtra("score");

        String score_correct = getIntent().getStringExtra("correct");
        corectQ.setText(score_correct);

        String score_wrong = getIntent().getStringExtra("wrong");
        wrongQ.setText(score_wrong);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WonActivity.this, MyProfileActivity.class);
                intent.putExtra("profile_score" , String.valueOf(score_str));
                intent.putExtra("score_final",String.valueOf(score_final));
                startActivity(intent);

            }
        });







    }
}