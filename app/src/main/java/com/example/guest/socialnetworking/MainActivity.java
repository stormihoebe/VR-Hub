package com.example.guest.socialnetworking;

import android.graphics.Typeface;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mBannerText;
    private TextView mBannerText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBannerText = (TextView) findViewById(R.id.bannerText);
        mBannerText2 = (TextView) findViewById(R.id.bannerText2);

        Typeface crash = Typeface.createFromAsset(getAssets(), "fonts/crash.ttf");
        mBannerText.setTypeface(crash);
        mBannerText2.setTypeface(crash);
    }
}
