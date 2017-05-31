package com.example.guest.socialnetworking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Contact extends AppCompatActivity {
    @Bind(R.id.ContactSubmitButton) Button mcontactSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ButterKnife.bind(this);
        mcontactSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Contact.this, "Thank you!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
