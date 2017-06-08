package com.example.guest.socialnetworking.models;

/**
 * Created by Guest on 6/1/17.
 */

public class Tweet {
    private String mTime;
    private String mText;
    private String mUrl;

    public Tweet(String text, String time, String url) {
        this.mTime = time;
        this.mText = text;
        this.mUrl = url;
    }

    public String getText(){
        return mText;
    }

    public String getTime() {
        return mTime;
    }

    public String getUrl() { return mUrl; }
}
