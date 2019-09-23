package com.example.casanova;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.concurrent.ExecutionException;

public class brodreviv extends BroadcastReceiver {

    public brodreviv() {

    }


    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        if (Intent.ACTION_BOOT_COMPLETED.equals(action)) {
            startServiceByAlarm(context);
        }
    }

    public static void startServiceByAlarm(Context context) {
        final getfromjson parsejson = new getfromjson();
        try {
            parsejson.execute().get();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (ExecutionException e) {

            e.printStackTrace();
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, Sherlocs.class);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        long startTime = System.currentTimeMillis();

        assert alarmManager != null;

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, startTime, Long.parseLong((parsejson.getAlarme2())), pendingIntent);
    }

}
