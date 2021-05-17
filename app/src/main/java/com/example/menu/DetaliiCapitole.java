package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DetaliiCapitole extends AppCompatActivity {

    PDFView myPDFViewer;

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
        setContentView(R.layout.activity_detalii_capitole);

        bottomNavigationView= findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        myPDFViewer = (PDFView) findViewById(R.id.pdfViewer);

        String getItem = getIntent().getStringExtra("pdfFileName");

        if(getItem.equals("Elemente de algebră clasa a X-a")){
            myPDFViewer.fromAsset("elemente_de_algebra.pdf").load();
        }

        if(getItem.equals("Elemente de analiză matematică clasa a X-a")){
            myPDFViewer.fromAsset("elemente_de_analiza.pdf").load();
        }

        if(getItem.equals("Elemente de algebră clasa a XI-a")){
            myPDFViewer.fromAsset("Inteligenta.pdf").load();
        }

        if(getItem.equals("Elemente de analiză matematică clasa a XI-a")){
            myPDFViewer.fromAsset("Inteligenta.pdf").load();
        }

        if(getItem.equals("Elemente de algebră clasa a XII-a")){
            myPDFViewer.fromAsset("Inteligenta.pdf").load();
        }

        if(getItem.equals("Elemente de analiză matematică clasa a XII-a")){
            myPDFViewer.fromAsset("Inteligenta.pdf").load();
        }


    }

}