package com.example.guest.socialnetworking.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guest.socialnetworking.R;

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
}
