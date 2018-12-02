package com.example.oleg.myapplication4;
//package com.journaldev.threads;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.media.Image;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.concurrent.TimeUnit;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView, imageView2;
    private Animation animOne, animTwo, animThree, animFour;
    private CheckBox check1;
    boolean b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        animOne = AnimationUtils.loadAnimation(this, R.anim.animation_one);
        animTwo = AnimationUtils.loadAnimation(this, R.anim.animation_two);
        animThree = AnimationUtils.loadAnimation(this, R.anim.animation_three);
        animFour = AnimationUtils.loadAnimation(this, R.anim.animation_four);
        check1 = findViewById(R.id.checkBox);
        /*check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    b1=true;
                } else {
                   b1=false;
                }
            }
        });*/


    }


    public void onAnimationImageOne(View v) {


        if (check1.isChecked()) {
//            try {
//                imageView.startAnimation(animOne);
//                Thread.sleep(3000);
//                imageView2.startAnimation(animTwo);
//            } catch (InterruptedException e) {
//                System.out.println("interrupted!");
//            }
            imageView.startAnimation(animOne);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    imageView2.startAnimation(animOne);
                }
            },1000);
        }
        else {
            imageView.startAnimation(animOne);
            imageView2.startAnimation(animOne);
        }

    }


    public void onAnimationImageTwo(View v) {
        imageView.startAnimation(animTwo);
    }

    public void onAnimationImageThree(View v) {
        imageView.startAnimation(animThree);
    }

    public void onAnimationImageFour(View v) {
        imageView.startAnimation(animFour);
    }
}


