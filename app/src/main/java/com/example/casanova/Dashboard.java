package com.example.casanova;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.squareup.picasso.Picasso;
import com.startapp.android.publish.ads.nativead.StartAppNativeAd;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;

import java.util.concurrent.ExecutionException;

public class Dashboard extends AppCompatActivity  {
    private StartAppAd startAppAd = new StartAppAd(this);

    private StartAppNativeAd startAppNativeAd = new StartAppNativeAd(this);
    ImageView myImageView;

    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        final getfromjson parsejson = new getfromjson();
        try {
            parsejson.execute().get();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (ExecutionException e) {

            e.printStackTrace();
        }

        StartAppSDK.init(Dashboard.this, (parsejson.getStartappAd()), true);

        StartAppAd.disableSplash();

        linearLayout1 = (LinearLayout) findViewById( R.id.ad1 );
        linearLayout2 = (LinearLayout) findViewById( R.id.ad6 );
        linearLayout1.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Dashboard.this, LoadingThird.class);
                startActivity(intent);
              startAppAd.loadAd(StartAppAd.AdMode.REWARDED_VIDEO);
                startAppAd.showAd();

            }
        } );

        ///////////////// Ad 6 //////////////
        linearLayout2.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                    Intent intent = new Intent(Dashboard.this, LoadingSixth.class);
                    startActivity(intent);


            }
        } );
        allos();






        final getfromjson parsejsons = new getfromjson();
        try {
            parsejsons.execute().get();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (ExecutionException e) {

            e.printStackTrace();
        }


        myImageView = (ImageView) findViewById(R.id.ButtonView);
        ImageButton myButton = (ImageButton) findViewById(R.id.ButtonView);

        Picasso.get().load((parsejsons.getImg())).into(myImageView);
        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse((parsejsons.getClique()))));


            }
        });


    }



    public void Page1(View view) {
        Intent intent = new Intent(this, LoadingFirst.class);
        startActivity(intent);
        startAppAd.showAd();

    }

    public void Page2(View view) {
        Intent intent = new Intent(this, LoadingSecond.class);
        startActivity(intent);
    }



    public void Page4(View view) {
        Intent intent = new Intent(this, LoadingFourth.class);
        startActivity(intent);

    }
    public void Page5(View view) {
        Intent intent = new Intent(this, LoadingFifth.class);
        startActivity(intent);
        startAppAd.showAd();
    }


    public void allos () {
        opendialog mydialo = new opendialog();
        mydialo.show(getSupportFragmentManager(),"mydialo");
    }


}
