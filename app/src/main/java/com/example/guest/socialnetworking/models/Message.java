package com.example.guest.socialnetworking.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 6/8/17.
 */
// TODO: 6/8/17  Save and retrieve data using Firebase, making sure to structure your data according to Firebase guidelines.
// TODO: 6/8/17  Employ the Firebase-RecyclerAdapter to display from your database.
// TODO: 6/8/17 Use SharedPreferences to save an important piece of data in your app. 
// TODO: 6/8/17 Update README 
// TODO: 6/8/17  Implicit Intent

@Parcel
public class Message {
    String title;
    String body;
    String author;
    String uID;

    public Message() {}

    public Message (String title, String body, String author, String uid){
        this.title = title;
        this.body = body;
        this.author = author;
        this.uID = uid;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getuID() {
        return uID;
    }
}
