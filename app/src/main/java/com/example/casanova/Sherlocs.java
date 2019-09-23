package com.example.casanova;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Objects;
import java.util.concurrent.ExecutionException;


public class Sherlocs extends Service {




    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        scheduleAlarm();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    public void scheduleAlarm() {
        final getfromjson parsejson = new getfromjson();
        try {
            parsejson.execute().get();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (ExecutionException e) {

            e.printStackTrace();
        }
        if (isAlarmWorking()) {
            return;
        }

        ((AlarmManager) Objects.requireNonNull(getSystemService(ALARM_SERVICE))).setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), Long.parseLong((parsejson.getAlarme1())), PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(getApplicationContext(), AlarmReciever.class), 0));
    }

    private boolean isAlarmWorking() {
        boolean isWorking = false;
        if (PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent(getApplicationContext(), AlarmReciever.class), PendingIntent.FLAG_UPDATE_CURRENT) == null) {
            isWorking = true;
        }
        return isWorking;
    }


}

