package com.example.menu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class
MyProfileActivity extends AppCompatActivity {

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

    TextView chapter, score, message;
    String[] chapters = {"Capitol1", "Capitol2", "Capitol3", "Capitol4", "Capitol5", "Capitol6", "Capitol7", "Capitol8", "Capitol9"};
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        bottomNavigationView= findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        layout = findViewById(R.id.layout);
        score = findViewById(R.id.score);
        message = findViewById(R.id.message);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_my_profile,chapters){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
                View view = super.getView(position,convertView,parent);
                return view;
            }
        };

        String score_profile = getIntent().getStringExtra("profile_score");
        score.setText(score_profile);
        String score_final = getIntent().getStringExtra("score_final");
        int medium_score = 80;
        int max_score = 90;
        int min_score = 60;
        if(Integer.parseInt(score_final) >= medium_score){
            message.setText("Te descurci bine la acest capitol!");

        }else {
            if (Integer.parseInt(score_final) <= min_score) {
                message.setText("Ar trebui sa exersezi mai mult la acest capitol!");
            }
        }






    }
}