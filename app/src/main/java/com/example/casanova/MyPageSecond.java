package com.example.casanova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;

import java.util.concurrent.ExecutionException;

public class MyPageSecond extends AppCompatActivity {
    private AdView mAdView;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final getfromjson parsejson = new getfromjson();
        try {
            parsejson.execute().get();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (ExecutionException e) {

            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagesecond);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId((parsejson.getAdsinterstitial()));
        AdRequest adRequestt = new AdRequest.Builder()
                //.addTestDevice("TEST")
                .build();
        mInterstitialAd.loadAd(adRequestt);
        mInterstitialAd.setAdListener(new AdListener()
        {
            public void onAdLoaded()
            {
                mInterstitialAd.show();
            }
        });
        StartAppSDK.init(this, (parsejson.getStartappAd()), true);


        String myurl = (parsejson.isText2());
        WebView view = (WebView) this.findViewById(R.id.webView);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(myurl);
    }
}
