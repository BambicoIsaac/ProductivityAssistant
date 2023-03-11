package com.example.productivityassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class PositivityBoost extends AppCompatActivity {
    Random random = new Random();
    TextView textQuote;
    Button positiveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_positivity_boost);
        textQuote = findViewById(R.id.PositivityQuote);
        positiveButton = findViewById(R.id.PositivityButton);

        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayQuote();
            }
        });
    }

    public void displayQuote(){
        int randNum = random.nextInt(( 10 + 1) - 1) + 1;
        String PositiveQuote = "";


        switch(randNum){
            case 1 :
                PositiveQuote = getString(R.string.Quote1);
                break;
            case 2 :
                PositiveQuote = getString(R.string.Quote2);
                break;
            case 3 :
                PositiveQuote = getString(R.string.Quote3);
                break;
            case 4 :
                PositiveQuote = getString(R.string.Quote4);
                break;
            case 5 :
                PositiveQuote = getString(R.string.Quote5);
                break;
            case 6 :
                PositiveQuote = getString(R.string.Quote6);
                break;
            case 7 :
                PositiveQuote = getString(R.string.Quote7);
                break;
            case 8 :
                PositiveQuote = getString(R.string.Quote8);
                break;
            case 9 :
                PositiveQuote = getString(R.string.Quote9);
                break;
            case 10 :
                PositiveQuote = getString(R.string.Quote10);
                break;
        }

        textQuote.setText(PositiveQuote);
    }
}