package com.example.guest.socialnetworking.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.guest.socialnetworking.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.toJoinTextView) TextView mJoinTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mJoinTextView.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view == mJoinTextView) {
            Intent intent = new Intent(Login.this, JoinActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
