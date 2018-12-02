package com.example.anton.e1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Main extends AppCompatActivity {
 Button res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

       public void OnClick1(View v){
         res = findViewById(R.id.button);
         res.setBackgroundColor(Color.GREEN);
        res.setText("HELLO ");
        }


    }

