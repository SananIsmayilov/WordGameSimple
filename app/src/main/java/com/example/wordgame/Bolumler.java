package com.example.wordgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Bolumler extends AppCompatActivity {
    String[] bolumler = {"Bölüm 1", "Bölüm 2"};
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    Animation animation ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolumler);
        listView = findViewById(R.id.list);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bolumler);
        listView.setAdapter(arrayAdapter);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation);
        listView.setAnimation(animation);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    start();
                } else {
                    Toast.makeText(getApplicationContext(), "Yaxın zamanda hazır olacaq...", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void start() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}