package com.ndscompany.myfirstvkapp;

import android.os.Trace;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ndscompany.myfirstvkapp.app.App;
import com.ndscompany.myfirstvkapp.classes.News;
import com.ndscompany.myfirstvkapp.repository.IWallRepository;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvNews;
    private NewsAdapter adapter;
    private RelativeLayout rlProgress;
    private SwipeRefreshLayout srlNews;
    private TextView tvTollBarTitle;
    private AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvNews = findViewById(R.id.rv_activity_main_news);
        rlProgress = findViewById(R.id.rl_main_progress);
        srlNews = findViewById(R.id.swl_activity_main);
        srlNews.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getNews();
            }
        });
        tvTollBarTitle = findViewById(R.id.tv_activity_base_title);
        tvTollBarTitle.setText(R.string.activity_title);
        appBarLayout = findViewById(R.id.app_bar_layout);
        tvTollBarTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rvNews.scrollToPosition(0);
            }
        });
        adapter = new NewsAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvNews.setLayoutManager(linearLayoutManager);
        rvNews.setAdapter(adapter);
        getNews();
    }

    private void getNews(){
        startLoading();
        App.getmIstance().getWallApiRepository().getNewsFromApi(new IWallRepository.GetNewsFromApiCallback() {
            @Override
            public void setNews(ArrayList<News> news) {
                adapter.setNews(news);
                completeLoading();
            }

            @Override
            public void error(String message) {
                completeLoading();
                showError(message);
            }
        });
    }

    private void showError(String message){
        Toast.makeText(this, message,Toast.LENGTH_LONG).show();
    }

    private void startLoading(){
//        rlProgress.setVisibility(View.VISIBLE);
        srlNews.setRefreshing(true);
    }

    private void completeLoading(){
//        rlProgress.setVisibility(View.GONE);
        srlNews.setRefreshing(false);
    }
}
