package com.project.gofoodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        // Setting onClickListener for Various Buttons Created
        button = (Button) findViewById(R.id.swallow);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openswallow();
            }

        });

        button = (Button) findViewById(R.id.soup_stew);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensoup();
            }

        });

        button = (Button) findViewById(R.id.meat);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmeat();
            }

        });

        button = (Button) findViewById(R.id.drinks);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendrinks();
            }

        });

        button = (Button) findViewById(R.id.about);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openabout();
            }

        });

        button = (Button) findViewById(R.id.contact);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencontact();
            }

        });
    }
    // Creating Intents for the buttons
    public void openswallow(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void opensoup(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void openmeat(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void opendrinks(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void openabout(){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
    public void opencontact(){
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }
}
