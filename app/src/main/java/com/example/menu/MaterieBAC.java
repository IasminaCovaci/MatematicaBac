package com.example.menu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MaterieBAC extends AppCompatActivity {

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

    ListView listView;
    LayoutParams layoutparams;
    String[] chapters = {"Elemente de algebră clasa a X-a", "Elemente de analiză matematică clasa a X-a", "Elemente de algebră clasa a XI-a", "Elemente de analiză matematică clasa a XI-a", "Elemente de algebră clasa a XII-a", "Elemente de analiză matematică clasa a XII-a"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materie_b_a_c);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        listView = (ListView) findViewById(R.id.listview);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,chapters){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position,convertView,parent);
                TextView myText = (TextView) view.findViewById(android.R.id.text1);
                myText.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
                myText.setTypeface(myText.getTypeface(), Typeface.BOLD);
                myText.setTextColor(Color.parseColor("#000000"));
                layoutparams = view.getLayoutParams();

                layoutparams.height = 250;

                view.setLayoutParams(layoutparams);
                return view;
            }
        };

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = listView.getItemAtPosition(position).toString();
                Intent intent = new Intent(getApplicationContext(),DetaliiCapitole.class);
                intent.putExtra("pdfFileName",item);
                startActivity(intent);
            }
        });
        listView.setAdapter(arrayAdapter);


    }

}