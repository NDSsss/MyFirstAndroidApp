package com.ndscompany.myfirstvkapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvNews = findViewById(R.id.rv_activity_main_news);
        ArrayList<String> news = new ArrayList<>();
        news.add("One");
        news.add("Two");
        news.add("Three");
        news.add("Four");
        news.add("Five");
        news.add("One");
        news.add("Two");
        news.add("Three");
        news.add("Four");
        news.add("Five");
        news.add("One");
        news.add("Two");
        news.add("Three");
        news.add("Four");
        news.add("Five");
        news.add("One");
        news.add("Two");
        news.add("Three");
        news.add("Four");
        news.add("Five");
        NewNewsAdapter adapter = new NewNewsAdapter(news);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvNews.setLayoutManager(linearLayoutManager);
        rvNews.setAdapter(adapter);
    }
}
