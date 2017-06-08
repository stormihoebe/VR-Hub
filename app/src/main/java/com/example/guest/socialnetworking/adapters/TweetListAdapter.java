package com.example.guest.socialnetworking.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guest.socialnetworking.R;
import com.example.guest.socialnetworking.models.Tweet;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 6/1/17.
 */

public class TweetListAdapter extends RecyclerView.Adapter<TweetListAdapter.TweetViewHolder> {
    private ArrayList<Tweet> mTweets = new ArrayList<>();
    private Context mContext;

    public TweetListAdapter(Context context, ArrayList<Tweet> tweets) {
        mContext = context;
        mTweets = tweets;
    }

    @Override
    public TweetListAdapter.TweetViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tweet_item, parent, false);
        TweetViewHolder viewHolder = new TweetViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(TweetListAdapter.TweetViewHolder holder, int position) {
        holder.bindTweet(mTweets.get(position));
    }
    @Override
    public int getItemCount(){
        return  mTweets.size();
    }

    public class TweetViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.textTextView) TextView mTextTextView;
        @Bind(R.id.timeTextView) TextView mTimeTextView;

        private Context mContext;

        public TweetViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindTweet(Tweet tweet){
            mTextTextView.setText(tweet.getText());
            mTimeTextView.setText(tweet.getTime());
        }
    }
}
