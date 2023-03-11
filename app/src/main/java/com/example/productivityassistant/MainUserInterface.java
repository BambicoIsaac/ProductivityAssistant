package com.example.productivityassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainUserInterface extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user_interface);
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);

    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(finalI==0) {
                        Intent intent = new Intent(MainUserInterface.this, AlarmMain.class);
                        startActivity(intent);
                    }
                    if(finalI==1) {
                        Intent intent = new Intent(MainUserInterface.this, RemindersMain.class);
                        startActivity(intent);
                    }
                    if(finalI==2) {
                        Intent intent = new Intent(MainUserInterface.this, Notes.class);
                        startActivity(intent);
                    }
                    if(finalI==3) {
                        Intent intent = new Intent(MainUserInterface.this, PositivityBoost.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }
}