package com.example.guest.socialnetworking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ExploreActivity extends AppCompatActivity {
    @Bind(R.id.ExploreListView) ListView mexploreListView;
    private String[] messages = new String[]  {"Exciting news in Virtual Reality", "Virtual Reality For Beginners", "Designing Assets for VR/MR", "How to Optimize your mixed reality experience."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_explore);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, messages);
        mexploreListView.setAdapter(adapter);
    }
}
