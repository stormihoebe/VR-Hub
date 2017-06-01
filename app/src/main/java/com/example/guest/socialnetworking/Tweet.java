package com.example.guest.socialnetworking;

/**
 * Created by Guest on 6/1/17.
 */

public class Tweet {
    private String mTime;
    private String mText;

    public Tweet(String text, String time) {
        this.mTime = time;
        this.mText = text;
    }

    public String getText(){
        return mText;
    }

    public String getTime() {
        return mTime;
    }
}
