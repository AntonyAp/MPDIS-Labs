package com.example.anton.lab4;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
EditText duration;
    private ImageView img1, img;
    Animation animation,animation1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        duration=(EditText)findViewById(R.id.duration);
    }
    public void onClick(View view) {
         img = (ImageView)findViewById(R.id.first);
        animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        img.startAnimation(animation);

         img1 = (ImageView)findViewById(R.id.second);
        img1.startAnimation(animation);

    }

    public void onClick1(View view) {
         img = (ImageView)findViewById(R.id.first);
        animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        img.startAnimation(animation);

         animation1 = AnimationUtils.loadAnimation(this, R.anim.anim1);
         img1 = (ImageView)findViewById(R.id.second);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                img1.startAnimation(animation1);
            }
        },6000);

    }

    public void onClick2(View view) {
        img = (ImageView)findViewById(R.id.first);
         img1 = (ImageView)findViewById(R.id.second);
         animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        if (duration.getText().toString()!= null) {
            String rez=duration.getText().toString();
            Integer a = Integer.parseInt(rez);
            animation.setDuration(a);
            img1.startAnimation(animation);
            img.startAnimation(animation);
        }
    }
}
