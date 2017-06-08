package com.example.guest.socialnetworking.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guest.socialnetworking.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.Bind;
import butterknife.ButterKnife;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = JoinActivity.class.getSimpleName();

    @Bind(R.id.joinButton) Button mjoinButton;
    @Bind(R.id.NewUserName) EditText muserName;
    @Bind(R.id.NewUserEmail) EditText muserEmail;
    @Bind(R.id.newUserPasswordEditText) EditText muserPassword;
    @Bind(R.id.toLoginTextView) TextView mtoLogin;

    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join2);
        ButterKnife.bind(this);
        createAuthStateListener();

        mAuth = FirebaseAuth.getInstance();

        mjoinButton.setOnClickListener(this);
        mtoLogin.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view == mtoLogin) {
            Intent intent = new Intent(JoinActivity.this, Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        if (view == mjoinButton) {
            createNewUser();
        }
    }

    private void createAuthStateListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(JoinActivity.this, Landing.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }

        };
    }

    public void createNewUser() {
        final String name = muserName.getText().toString().trim();
        final String email = muserEmail.getText().toString().trim();
        final String password = muserPassword.getText().toString().trim();


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "Authentication successful");
                        } else {
                            Toast.makeText(JoinActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
