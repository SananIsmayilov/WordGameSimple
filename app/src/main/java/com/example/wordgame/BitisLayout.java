package com.example.wordgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BitisLayout extends AppCompatActivity {
int dogrusualsayi=0,cavabverilen=0;
Button buttonbolum;
TextView textViewsualsayi,textdogru,textyanlis,textcavabverilmemis;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitis_layout);
        Intent intent = getIntent();
        dogrusualsayi = intent.getIntExtra("dogru", 0);
        cavabverilen = intent.getIntExtra("cavab", 0);
        initialize();

        textViewsualsayi.setText("Ümumi sual sayı : 10");
        textdogru.setText("Doğru cavab sayınız : "+ String.valueOf(dogrusualsayi));
        textyanlis.setText("Yanlış cavab sayınız : " + String.valueOf((cavabverilen - dogrusualsayi)));
        textcavabverilmemis.setText("Cavab vermədiyiniz sual sayı  : " +String.valueOf((10 - cavabverilen)));
        buttonbolum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Bolumler.class);
                startActivity(intent1);
            }
        });
    }

    public void initialize() {
        textViewsualsayi = findViewById(R.id.sualsayi);
        textdogru = findViewById(R.id.dogrusualsayi);
        textyanlis = findViewById(R.id.yanlissualsayi);
        textcavabverilmemis = findViewById(R.id.cavabverilmemissualsayi);
        buttonbolum = findViewById(R.id.backbolum);
    }
}