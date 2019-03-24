package com.example.smartcardsnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartcardsnew.Models.Cards;

public class EditCardActivity extends AppCompatActivity {
//Need to get text from EditText Views and update card name
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_card);

        Button saveCardButton = (Button) findViewById(R.id.saveCard_button);
        saveCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //CardListActivity.addCard();
                //Need to add String from Edit Text to the Card Name
                Intent SaveIntent = new Intent(EditCardActivity.this, CardListActivity.class);
                startActivity(SaveIntent);
            }
        });
    }

}
