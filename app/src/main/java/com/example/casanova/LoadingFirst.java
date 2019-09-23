package com.example.casanova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class LoadingFirst extends AppCompatActivity {
    private AnimationUtil animationUtil;
    private boolean isAnimationStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loadingfirst);
        RelativeLayout animationLayout = (RelativeLayout) findViewById(R.id.animationLayout);
        ImageView animationView = (ImageView) findViewById(R.id.animationView);


        final Intent i = new Intent (this, MyPageFirst.class);

        animationUtil = new AnimationUtil(getApplicationContext(), animationView, animationLayout);
        isAnimationStart = !isAnimationStart;
        if(isAnimationStart){
            animationUtil.start();

        }

        Thread timer = new Thread() {

            public void run () {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();

                }
            }
        };
        timer.start();


            }




}