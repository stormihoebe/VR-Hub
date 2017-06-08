package com.example.guest.socialnetworking.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.guest.socialnetworking.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Landing extends AppCompatActivity {
    @Bind(R.id.contactButton) Button mcontactButton;
    @Bind(R.id.aboutButton) Button maboutButton;
    @Bind(R.id.exploreButton) Button mexploreButton;
    @Bind(R.id.WelcomeTextView) TextView mwelcomeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mwelcomeTextView.setText("Welcome, " + name);
        maboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Landing.this, About.class);
                startActivity(intent);
            }
        });
        mcontactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Landing.this, Contact.class);
                startActivity(intent);
            }
        });
        mexploreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Landing.this, ExploreActivity.class);
                startActivity(intent);
            }
        });
    }
}
