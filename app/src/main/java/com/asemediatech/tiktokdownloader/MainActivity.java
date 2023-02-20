package com.asemediatech.tiktokdownloader;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.asemediatech.tiktokdownloader.utils.ThemeUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    private ThemeUtils themeUtils = new ThemeUtils();
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-5977365730645902~9028987250");
        Fresco.initialize(this);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        themeUtils.statusBarTransparent(this);
        themeUtils.tabUtils(this, getSupportFragmentManager());


    }




}

