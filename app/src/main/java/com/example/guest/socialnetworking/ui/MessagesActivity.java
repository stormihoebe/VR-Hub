package com.example.guest.socialnetworking.ui;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.guest.socialnetworking.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MessagesActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.addMessaButton)Button mAddMessageButton;
    @Bind(R.id.messagessRecyclerView)RecyclerView mRecyclerView;

    private DatabaseReference mMessageReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        ButterKnife.bind(this);

        mAddMessageButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == mAddMessageButton) {
            FragmentManager fm = getFragmentManager();
            NewMessageFragment newMessageFragment = new NewMessageFragment();
            newMessageFragment.show(fm, "Message Fragment");
        }
    }

}
