package com.example.casanova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.startapp.android.publish.adsCommon.StartAppSDK;

import java.util.concurrent.ExecutionException;

public class MyPageFirst extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagefirst);
        final getfromjson parsejson = new getfromjson();
        try {
            parsejson.execute().get();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (ExecutionException e) {

            e.printStackTrace();
        }
        StartAppSDK.init(this, (parsejson.getStartappAd()), true);


        String myurl = (parsejson.isText1());
        WebView view = (WebView) this.findViewById(R.id.webView);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(myurl);

    }
}
