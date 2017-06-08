package com.example.guest.socialnetworking.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guest.socialnetworking.R;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.Bind;
import butterknife.ButterKnife;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.joinButton) Button mjoinButton;
    @Bind(R.id.NewUserName) EditText muserName;
    @Bind(R.id.NewUserEmail) EditText muserEmail;
    @Bind(R.id.newUserPasswordEditText) EditText muserPassword;
    @Bind(R.id.toLoginTextView) TextView mtoLogin;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join2);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();

        mjoinButton.setOnClickListener(this);
        mtoLogin.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view == mtoLogin) {
            Intent intent = new Intent(JoinActivity.this, Login.class);
            startActivity(intent);
            finish();
        }
        if (view == mjoinButton) {
            createNewUser();
        }
    }
    public void createNewUser() {
        final String name = muserName.getText().toString().trim();
        final String username = muserEmail.getText().toString().trim();
        final String password = muserPassword.getText().toString().trim();
// TODO: 6/8/17  FINISH THIS CREATE NEW USER IN
    }
}
