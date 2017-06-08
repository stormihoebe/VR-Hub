package com.example.guest.socialnetworking.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.guest.socialnetworking.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Landing extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.exploreButton) Button mexploreButton;
    @Bind(R.id.WelcomeTextView) TextView mwelcomeTextView;
    @Bind(R.id.messagesButton) Button mMessageButton;


    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    mwelcomeTextView.setText("Welcome, " + user.getDisplayName() + "!");

                } else {
                    Log.d("HEY", "user is NULL");

                }
            }
        };

        mexploreButton.setOnClickListener(this);
        mMessageButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view == mexploreButton) {
            Intent intent = new Intent(Landing.this, ExploreActivity.class);
            startActivity(intent);
            finish();
        }
        if (view == mMessageButton) {
            Intent intent = new Intent(Landing.this, MessagesActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        if(id == R.id.action_about) {
            Intent intent = new Intent(Landing.this, About.class);
            startActivity(intent);
        }
        if(id == R.id.action_contact){
            Intent intent = new Intent(Landing.this, Contact.class);
            startActivity(intent);
        }
        if(id == R.id.action_home){
            Intent intent = new Intent(Landing.this, Landing.class);
            startActivity(intent);
        }
        if(id == R.id.action_explore){
            Intent intent = new Intent(Landing.this, ExploreActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(Landing.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
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
