package com.example.guest.socialnetworking.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guest.socialnetworking.R;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Contact extends AppCompatActivity {
    @Bind(R.id.ContactSubmitButton) Button mcontactSubmitButton;
    @Bind(R.id.emailEditText) EditText mEmail;
    @Bind(R.id.nameEditText) EditText mName;
    @Bind(R.id.editText) EditText mMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ButterKnife.bind(this);
        mcontactSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mName.getText().toString();
                String email = mEmail.getText().toString();
                String message = mMessage.getText().toString();
                if( name.equals("")|| email.equals("") || message.equals("") ){
                    Toast.makeText(Contact.this, "Please Fill Out All Fields", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Contact.this, "Thank you!", Toast.LENGTH_LONG).show();
                }
            }
        });
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
            Intent intent = new Intent(Contact.this, About.class);
            startActivity(intent);
        }
        if(id == R.id.action_contact){
            Intent intent = new Intent(Contact.this, Contact.class);
            startActivity(intent);
        }
        if(id == R.id.action_home){
            Intent intent = new Intent(Contact.this, Landing.class);
            startActivity(intent);
        }
        if(id == R.id.action_explore){
            Intent intent = new Intent(Contact.this, ExploreActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(Contact.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
