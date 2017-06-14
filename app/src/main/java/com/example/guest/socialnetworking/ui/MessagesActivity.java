package com.example.guest.socialnetworking.ui;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.guest.socialnetworking.BounceInterpolator;
import com.example.guest.socialnetworking.R;
import com.example.guest.socialnetworking.adapters.FirebaseMessageViewHolder;
import com.example.guest.socialnetworking.models.Message;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        BounceInterpolator interpolator = new BounceInterpolator(0.2, 20);
        final Animation bounceAnim = AnimationUtils.loadAnimation(this,R.anim.bounce);
        mAddMessageButton.startAnimation(bounceAnim);
        bounceAnim.setInterpolator(interpolator);

        mAddMessageButton.setOnClickListener(this);

        mMessageReference = FirebaseDatabase.getInstance().getReference().child("messages");
        setUpFirebaseAdapter();
    }

    @Override
    public void onClick(View v) {
        if(v == mAddMessageButton) {
            FragmentManager fm = getFragmentManager();
            NewMessageFragment newMessageFragment = new NewMessageFragment();
            newMessageFragment.show(fm, "Message Fragment");

            BounceInterpolator interpolator = new BounceInterpolator(0.2, 20);
            final Animation bounceAnim = AnimationUtils.loadAnimation(this,R.anim.bounce);
            mAddMessageButton.startAnimation(bounceAnim);
            bounceAnim.setInterpolator(interpolator);

            mAddMessageButton.setOnClickListener(this);

            mMessageReference = FirebaseDatabase.getInstance().getReference().child("messages");
            setUpFirebaseAdapter();
        }
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Message, FirebaseMessageViewHolder>
                (Message.class, R.layout.message_list_item, FirebaseMessageViewHolder.class, mMessageReference) {

            @Override
            public void populateViewHolder(FirebaseMessageViewHolder viewHolder, Message model, int position) {

                viewHolder.bindTopic(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
        Log.d("reference", mMessageReference.getKey());
    }

}
