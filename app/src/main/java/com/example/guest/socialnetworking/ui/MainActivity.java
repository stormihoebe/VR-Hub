package com.example.guest.socialnetworking.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.guest.socialnetworking.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.bannerText) TextView mBannerText;
    @Bind(R.id.bannerText2) TextView mBannerText2;
    @Bind(R.id.joinButton) Button mjoinButton;
    @Bind(R.id.signInButton) Button msigntInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface crash = Typeface.createFromAsset(getAssets(), "fonts/crash.ttf");
        mBannerText.setTypeface(crash);
        mBannerText2.setTypeface(crash);

        mjoinButton.setOnClickListener(this);
        msigntInButton.setOnClickListener(this);

    }
    public  void onClick(View v) {
        if(v == mjoinButton) {
            Intent intent = new Intent(MainActivity.this, JoinActivity.class);
            startActivity(intent);
        }
        if(v == msigntInButton) {
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
        }
    }
}
