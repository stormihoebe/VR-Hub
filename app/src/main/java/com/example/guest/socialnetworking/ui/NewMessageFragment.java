package com.example.guest.socialnetworking.ui;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.socialnetworking.R;
import com.example.guest.socialnetworking.models.Message;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by storm on 6/9/2017.
 */

public class NewMessageFragment extends DialogFragment implements View.OnClickListener {

    private DatabaseReference mMessageReference;

    EditText mMessageEditText;
    EditText mTitleEditText;
    Button mSubmitButton;

    Message mMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_message_form, container, false);
        getDialog().setTitle("Topic Fragment");
        mMessageEditText = (EditText) rootView.findViewById(R.id.messageEditText);
        mTitleEditText = (EditText) rootView.findViewById(R.id.titleEditText);
        mSubmitButton = (Button) rootView.findViewById(R.id.submitMessageButton);

        mSubmitButton.setOnClickListener(this);

        mMessageReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child("messages");

        return rootView;
    }

    @Override
    public void onClick(View v) {
        if(v == mSubmitButton) {
            String title = mTitleEditText.getText().toString();
            String message = mMessageEditText.getText().toString();
            String author = "Author Name here";

            Message newMessage = new Message(title, message, author);
            saveMessageToFirebase(newMessage);
            dismiss();
        }
    }

    public void saveMessageToFirebase(Message newMessage) {
        DatabaseReference pushRef = mMessageReference.push();
        String pushId = pushRef.getKey();
        newMessage.setId(pushId);
        pushRef.setValue(newMessage);
    }
}
