package com.example.guest.socialnetworking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ExploreActivity extends AppCompatActivity {
    public static final String TAG = ExploreActivity.class.getSimpleName();

    @Bind(R.id.ExploreListView) ListView mexploreListView;
    @Bind(R.id.SearchEditText) EditText mSearch;

    private String[] messages = new String[] {"Exciting news in Virtual Reality", "Virtual Reality For Beginners", "Designing Assets for VR/MR", "How to Optimize your mixed reality experience."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        ButterKnife.bind(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, messages);
        String search = mSearch.getText().toString();
        mexploreListView.setAdapter(adapter);
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
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();

                    Log.v(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
    }
}
