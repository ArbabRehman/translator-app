package com.translator.bestlanguagestranslatorapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    private Button translateButton;
    private Button ocrButton;


    private InterstitialAd mInterstitialAd;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.ad_View);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }


    public void processLinear(View view) {

        if (view.getId() == R.id.llmFirst) {

            Intent i = new Intent(MainActivity.this, TranslateAct.class);
            startActivity(i);
        } else if (view.getId() == R.id.llmSecond) {

            Intent i = new Intent(MainActivity.this, Ocr_Act.class);
            startActivity(i);
        } else if (view.getId() == R.id.llmThird) {


            try {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market : //details?id" + getPackageName())));
            } catch (ActivityNotFoundException e) {

                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=com.translator.bestlanguagestranslatorapp&hl=en_US=" + getPackageName())));


            }
        } else if (view.getId() == R.id.llmFourth) {


            try {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=ArbabApps&hl=en&gl=US"));
                startActivity(browserIntent);
            } catch (Exception e) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=ArbabApps&hl=en&gl=US"));
                startActivity(browserIntent);
            }


        }
    }


    @Override
    public void onBackPressed() {
        ExitApp();

    }


    private void ExitApp() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle(getString(R.string.app_name2))
                .setMessage(getString(R.string.exit_msg))
                .setIcon(R.drawable.translate2)
                .setPositiveButton(getString(R.string.exit_yes), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton(getString(R.string.exit_no), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .show();
    }


}