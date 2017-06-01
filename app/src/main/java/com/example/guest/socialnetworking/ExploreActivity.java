package com.example.guest.socialnetworking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ExploreActivity extends AppCompatActivity {
    public static final String TAG = ExploreActivity.class.getSimpleName();

    @Bind(R.id.ExploreListView) ListView mexploreListView;
    @Bind(R.id.SearchEditText) EditText mSearch;

    public ArrayList<Tweet> mTweets = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        ButterKnife.bind(this);

        String search = mSearch.getText().toString();
        getTweets(search);
    }

    private void getTweets(String search){
        final TwitterService twitterService = new TwitterService();
        twitterService.findTweets(search, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mTweets = twitterService.processResults(response);

                ExploreActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] tweetText = new String[mTweets.size()];
                        for (int i=0; i < tweetText.length; i++) {
                            tweetText[i] = mTweets.get(i).getText();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(ExploreActivity.this, android.R.layout.simple_list_item_1, tweetText);
                        mexploreListView.setAdapter(adapter);

                    }
                });

            }

        });
    }
}
