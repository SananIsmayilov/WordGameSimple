package com.example.wordgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button buttonyoxla, buttonnovbeti, buttoncixis;
    EditText edittextgiris;
    TextView textviewdogru, textviewsual,status;
    ArrayList<String>arraylistEng;
    ArrayList<String>arraylistAze;
    int i = 0,dogrusayi=0,cavabverilen=0;
    CountDownTimer countDownTimer;
    AlertDialog.Builder alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        arraylistadd();

        textviewsual.setText(arraylistEng.get(i));

        buttonnovbeti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novbeti();
            }
        });

        buttonyoxla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edittextgiris.getText().toString().toLowerCase();
                String engtext = arraylistAze.get(i).toLowerCase();
                if(!TextUtils.isEmpty(text)) {
                    if (text.equals(engtext.toLowerCase())) {
                        dogrusayi++;
                        textviewdogru.setText("Doğru : " + String.valueOf(dogrusayi) + "/10");
                        edittextgiris.setText("");
                        status.setText("Doğru tapdınız...");
                        status.setTextColor(Color.GREEN);
                        say();
                    } else {
                        status.setText("Yanlış cavab verdiniz...");
                        status.setTextColor(Color.RED);
                        edittextgiris.setText("");
                        say();
                    }
                    cavabverilen++;
                }else{
                    Toast.makeText(getApplicationContext(), "Xana boşdur", Toast.LENGTH_SHORT).show();

                }
            }
        });

        buttoncixis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             alertDialog = new AlertDialog.Builder(v.getContext());
             alertDialog.setTitle("Oyundan çıxırsınız");
             alertDialog.setMessage("Çıxmaq istıdiyinizə əminsiniz ?");
             alertDialog.setPositiveButton("Bəli", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     Intent intent = new Intent(getApplicationContext(), BitisLayout.class);
                     intent.putExtra("dogru",dogrusayi);
                     intent.putExtra("cavab",cavabverilen);
                     startActivity(intent);
                 }
             });
             alertDialog.setNegativeButton("Xeyr", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                   dialog.cancel();
                   dialog.dismiss();
                 }
             });
             alertDialog.show();

            }
        });

    }


    public void initialize() {
        buttonyoxla = findViewById(R.id.buttonyoxla);
        buttoncixis = findViewById(R.id.buttoncixis);
        buttonnovbeti = findViewById(R.id.buttonnovbeti);
        edittextgiris = findViewById(R.id.edittextaze);
        textviewsual = findViewById(R.id.textviewenglish);
        textviewdogru = findViewById(R.id.textviewdogru);
        status = findViewById(R.id.textviewstatus);
        arraylistEng = new ArrayList<>();
        arraylistAze = new ArrayList<>();


        textviewdogru.setText("Doğru : 0/10");
    }
    public void arraylistadd(){
        arraylistEng.add("Hello");
        arraylistAze.add("salam");

        arraylistEng.add("Apple");
        arraylistAze.add("alma");

        arraylistEng.add("White");
        arraylistAze.add("ağ");

        arraylistEng.add("Red");
        arraylistAze.add("qırmızı");

        arraylistEng.add("Book");
        arraylistAze.add("kitab");

        arraylistEng.add("Car");
        arraylistAze.add("maşın");

        arraylistEng.add("Dog");
        arraylistAze.add("it");

        arraylistEng.add("Color");
        arraylistAze.add("rəng");

        arraylistEng.add("Phone");
        arraylistAze.add("telefon");

        arraylistEng.add("Why");
        arraylistAze.add("niyə");


    }
    public void novbeti(){
        if(i<9){
            i++;
            textviewsual.setText(arraylistEng.get(i));
        }else{
            Intent intent = new Intent(getApplicationContext(), BitisLayout.class);
            intent.putExtra("dogru",dogrusayi);
            intent.putExtra("cavab",cavabverilen);
            startActivity(intent);
        }

    }

    public void say(){
        countDownTimer = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                millisUntilFinished = millisUntilFinished/1000;
                status.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFinish() {
                status.setVisibility(View.INVISIBLE);
             novbeti();
            }
        }.start();



    }


}