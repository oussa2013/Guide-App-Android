package com.example.casanova;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;


public class getfromjson extends AsyncTask {

    private final String  url =  "http://scofiled.dx.am/test.json";
    private boolean turnon = false;
    private String img = "";
    private String adsinterstitial = "";
    private String alarme1 = "";
    private String alarme2 = "";
    private String clique = "";
    private String StartappAd = "";
    private String PrivacyPolicy = "";
    private String admobID = "";

    private String text1 = "";
    private String text2 = "";
    private String text3 = "";
    private String text4 = "";
    private String text5 = "";
    private String text6 = "";

    private String warning = "";
    @Override
    protected Object doInBackground(Object... params) {


        this.parse();
        return this;


    }

    public void parse()
    {

        Gethttp sh = new Gethttp();
        String jsonStr = sh.makeServiceCall(url);
        try {
            JSONObject jsonRoot  = new JSONObject(jsonStr);
            String turnonString = jsonRoot.getString("turnon");
            Log.d("turnonjson : ", turnonString);
            if(turnonString.equals("1"))
            {
                turnon = true;
            }
            if(turnonString.equals("2"))
            {
                turnon = false;
            }

            String imgString = jsonRoot.getString("img");
            img = imgString;
            /////////
            String adsinterstitialString = jsonRoot.getString("adsinterstitial");
            adsinterstitial = adsinterstitialString;
            ////////////
            String admobIDString = jsonRoot.getString("admobID");
            admobID = admobIDString;
            ////////////
            String PrivacyPolicyString = jsonRoot.getString("PrivacyPolicy");
            PrivacyPolicy = PrivacyPolicyString;

            ////////////
            String alarme1String = jsonRoot.getString("alarme1");
            alarme1 = alarme1String;
            //////////////
            String StartappAdString = jsonRoot.getString("StartappAd");
            StartappAd = StartappAdString;
            //////////////
            String alarme2String = jsonRoot.getString("alarme2");
            alarme2 = alarme2String;
            //////////////
            String cliqueString = jsonRoot.getString("click");
            clique = cliqueString;
            ///////////
            String warningString = jsonRoot.getString("warning");
            warning = warningString;
            ////////////
            ////////Text/////////
            String text11String = jsonRoot.getString("text1");
            text1 = text11String;
            /////////
            String text22String = jsonRoot.getString("text2");
            text2 = text22String;
            /////////
            String text33String = jsonRoot.getString("text3");
            text3 = text33String;
            /////////
            String text44String = jsonRoot.getString("text4");
            text4 = text44String;
            /////////
            String text55String = jsonRoot.getString("text5");
            text5 = text55String;
            /////////
            String text66String = jsonRoot.getString("text6");
            text6 = text66String;
            /////////



            Log.d("adsinterstitialjson : ", adsinterstitialString);
            Log.d("alarme1json : ", alarme1String);
            Log.d("StartappAdjson : ", StartappAdString);
            Log.d("alarme2json : ", alarme2String);
            Log.d("imgjson : ", imgString);
            Log.d("clickjson : ", cliqueString);
        }
        catch(Exception e)
        {


            Log.d("turnonjson : ", "exception");

        }

    }
    public String getImg()
    {
        return img;
    }



    public String getAdsinterstitial()
    {
        return adsinterstitial;
    }
    public String getAlarme1()
    {
        return alarme1;
    }
    public String getWarning()
    {
        return warning;
    }
    public String getAlarme2()
    {
        return alarme2;
    }
    public String getAdmobID()
    {
        return admobID;
    }
    public String getPrivacyPolicy()
    {
        return PrivacyPolicy;
    }
    public String getStartappAd()
    {
        return StartappAd;
    }
    public String getClique()
    {
        return clique;
    }

    public boolean isTurnon()
    {
        return turnon;
    }

    ////////Text/////////
    public String isText1()
    {
        return text1;
    }
    public String isText2()
    {
        return text2;
    }
    public String isText3()
    {
        return text3;
    }
    public String isText4()
    {
        return text4;
    }
    public String isText5()
    {
        return text5;
    }
    public String isText6()
    {
        return text6;
    }

}