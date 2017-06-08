package com.example.guest.socialnetworking.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.socialnetworking.R;
import com.example.guest.socialnetworking.adapters.TweetListAdapter;
import com.example.guest.socialnetworking.services.TwitterService;
import com.example.guest.socialnetworking.models.Tweet;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ExploreActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = ExploreActivity.class.getSimpleName();

    @Bind(R.id.exploreRecyclerView) RecyclerView mexploreRecyclerView;
    @Bind(R.id.SearchEditText) EditText mSearch;
    @Bind(R.id.goButton) Button mGoButton;
    private TweetListAdapter mAdapter;

    public ArrayList<Tweet> mTweets = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        ButterKnife.bind(this);
        String search = mSearch.getText().toString();
        getTweets("");
        mGoButton.setOnClickListener(this);
    }
    @Override
    public  void onClick(View v) {
        if(v == mGoButton) {
            String search = mSearch.getText().toString();
            getTweets(search);
        }
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
                        mAdapter = new TweetListAdapter(getApplicationContext(), mTweets);
                        mexploreRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ExploreActivity.this);
                        mexploreRecyclerView.setLayoutManager(layoutManager);
                        mexploreRecyclerView.setHasFixedSize(true);

                    }
                });

            }

        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        if(id == R.id.action_about) {
            Intent intent = new Intent(ExploreActivity.this, About.class);
            startActivity(intent);
        }
        if(id == R.id.action_contact){
            Intent intent = new Intent(ExploreActivity.this, Contact.class);
            startActivity(intent);
        }
        if(id == R.id.action_home){
            Intent intent = new Intent(ExploreActivity.this, Landing.class);
            startActivity(intent);
        }
        if(id == R.id.action_explore){
            Intent intent = new Intent(ExploreActivity.this, ExploreActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(ExploreActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
