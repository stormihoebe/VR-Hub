package com.example.guest.socialnetworking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class JoinActivity extends AppCompatActivity {
    @Bind(R.id.joinButton) Button mjoinButton;
    @Bind(R.id.NewUserName) TextView muserName;
    @Bind(R.id.NewUserEmail) TextView muserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join2);
        ButterKnife.bind(this);

        mjoinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String name = muserName.getText().toString();
            String email = muserEmail.getText().toString();
                if(name.equals("") || email.equals("")){
                    Toast.makeText(JoinActivity.this, "Name & Email Address Required!", Toast.LENGTH_LONG).show();

                }else{
                    Intent intent = new Intent(JoinActivity.this, Landing.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            }
        });
    }
}
