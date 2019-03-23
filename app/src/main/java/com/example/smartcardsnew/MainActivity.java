package com.example.smartcardsnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myCardsButton = (Button) findViewById(R.id.my_cards_button);
        myCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myCardsIntent = new Intent(MainActivity.this, MyCardsActivity.class);
                startActivity(myCardsIntent);
            }
        });

        Button smartLearnButton = (Button) findViewById(R.id.smart_learn_button);
        smartLearnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent smartLearnIntent = new Intent(MainActivity.this, SmartLearnActivity.class);
                startActivity(smartLearnIntent);
            }
        });
    }
}
