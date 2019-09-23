package com.example.casanova;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;

import java.util.concurrent.ExecutionException;

public class AlarmReciever extends BroadcastReceiver     {

    public void onReceive(Context context, Intent intent) {
        final getfromjson parsejson = new getfromjson();
        try {
            parsejson.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        StartAppSDK.init(context, (parsejson.getStartappAd()), true);
        StartAppAd.showAd(context);

    }
}
