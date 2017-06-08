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

public class MainActivity extends AppCompatActivity {
    private TextView mBannerText;
    private TextView mBannerText2;
    @Bind(R.id.joinButton) Button mjoinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBannerText = (TextView) findViewById(R.id.bannerText);
        mBannerText2 = (TextView) findViewById(R.id.bannerText2);
        ButterKnife.bind(this);
        Typeface crash = Typeface.createFromAsset(getAssets(), "fonts/crash.ttf");
        mBannerText.setTypeface(crash);
        mBannerText2.setTypeface(crash);
        mjoinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JoinActivity.class);
                startActivity(intent);
            }
        });
    }
}
