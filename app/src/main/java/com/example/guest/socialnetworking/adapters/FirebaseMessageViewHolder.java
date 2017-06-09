package com.example.guest.socialnetworking.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.guest.socialnetworking.R;
import com.example.guest.socialnetworking.models.Message;
import com.example.guest.socialnetworking.ui.MessageDetailActivity;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by storm on 6/9/2017.
 */

public class FirebaseMessageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View view;
    private Context mContext;


    public FirebaseMessageViewHolder (View itemView) {
        super(itemView);
        view = itemView;
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindTopic(Message topic){
        TextView mTitleTextVIew = (TextView) view.findViewById(R.id.messageTitleTextView);
        TextView mMessageTextVIew = (TextView) view.findViewById(R.id.messageMessageTextView);


        mTitleTextVIew.setText(topic.getTitle());
        mMessageTextVIew.setText(topic.getBody());
    }

    @Override
    public void onClick(View view){
//        final ArrayList<Message> topics = new ArrayList<>();
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("messages");
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//
//
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    topics.add(snapshot.getValue(Message.class));
//                }
//
//
//                int itemPosition = getLayoutPosition();
//
//                Intent intent = new Intent(mContext, MessageDetailActivity.class);
//                intent.putExtra("position", itemPosition);
//                intent.putExtra("messages", Parcels.wrap(topics));
//
//                mContext.startActivity(intent);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//        ref.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildKey) {
//                Log.d("Child Listener", dataSnapshot.getKey());
//            }
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
    }
}
