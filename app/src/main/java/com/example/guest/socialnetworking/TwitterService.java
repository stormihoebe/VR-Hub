package com.example.guest.socialnetworking;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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
}
