package com.example.guest.socialnetworking;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

public class TwitterService  {
   public static void findTweets(String search, Callback callback){
       OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.TWITTER_CONSUMER_KEY, Constants.TWITTER_CONSUMER_SECRET);
       consumer.setTokenWithSecret(Constants.TWITTER_TOKEN, Constants.TWITTER_TOKEN_SECRET);

       OkHttpClient client = new OkHttpClient.Builder()
               .addInterceptor(new SigningInterceptor(consumer))
               .build();

       HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.TWITTER_BASE_URL).newBuilder();
       String url = urlBuilder.build().toString() + "%20" + search;

       Request request= new Request.Builder()
               .url(url)
               .build();

       Call call = client.newCall(request);
       call.enqueue(callback);
   }

   public ArrayList<Tweet> processResults(Response response){
       ArrayList<Tweet> tweets = new ArrayList<>();

       try {
           String jsonData = response.body().string();
           if (response.isSuccessful()) {
               JSONObject twitterJSON = new JSONObject(jsonData);
               JSONArray tweetJSON = twitterJSON.getJSONArray("statuses");
               for (int i = 0; i < tweetJSON.length(); i++){
                   JSONObject statusJSON = tweetJSON.getJSONObject(i);
                   String time = statusJSON.getString("created_at");
                   String text = statusJSON.getString("text");
                   Tweet newTweet = new Tweet(text, time);
                   tweets.add(newTweet);
               }
           }
       } catch (JSONException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
       return tweets;

   }
}
