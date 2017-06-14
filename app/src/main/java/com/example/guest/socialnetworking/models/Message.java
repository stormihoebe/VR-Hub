package com.example.guest.socialnetworking.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 6/8/17.
 */

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
