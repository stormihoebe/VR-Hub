package com.example.guest.socialnetworking.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 6/8/17.
 */
// TODO: 6/8/17  Employ the Firebase-RecyclerAdapter to display from your database. (message board)
// TODO: 6/8/17 Use SharedPreferences to save an important piece of data in your app. (save username?)
// TODO: 6/8/17 Update README 
// TODO: 6/8/17  Implicit Intent (send message in contact)

@Parcel
public class Message {
    String title;
    String body;
    String author;
    String id;

    public Message() {}

    public Message (String title, String body, String author){
        this.title = title;
        this.body = body;
        this.author = author;

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

    public void setId(String id) {
        this.id = id;
    }
}
