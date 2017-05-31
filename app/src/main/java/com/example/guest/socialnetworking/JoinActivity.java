package com.example.guest.socialnetworking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class JoinActivity extends AppCompatActivity {
    @Bind(R.id.joinButton) Button mjoinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join2);
        ButterKnife.bind(this);

        mjoinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JoinActivity.this, Landing.class);
                startActivity(intent);
            }
        });
    }
}
