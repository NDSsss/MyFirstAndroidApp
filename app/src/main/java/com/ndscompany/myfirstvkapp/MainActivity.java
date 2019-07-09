package com.ndscompany.myfirstvkapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ndscompany.myfirstvkapp.data.VkResponse;
import com.ndscompany.myfirstvkapp.network.VkService;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvNews;
    private NewNewsAdapter adapter;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvNews = findViewById(R.id.rv_activity_main_news);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient cliet = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.vk.com/method/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(cliet)
                .build();
        adapter = new NewNewsAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvNews.setLayoutManager(linearLayoutManager);
        rvNews.setAdapter(adapter);
        getNews();
    }

    private void getNews(){
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("owner_id", "-154090709");
        map.put("domain", "kimkfu");
        map.put("count", "10");
        map.put("filter", "owner");
        map.put("extended", "0");
        map.put("v", "5.100");
        map.put("access_token", "293265a0293265a0293265a0d8295909bc22932293265a0742b992ec3a28b7cfcada41c");
        retrofit.create(VkService.class).getNews(map).enqueue(new Callback<VkResponse>() {
            @Override
            public void onResponse(Call<VkResponse> call, Response<VkResponse> response) {
                if(response.isSuccessful() && response.body() != null){
                    adapter.addNews(response.body().getResponse().getNews());
                } else {
                    showError("Response error");
                }
            }

            @Override
            public void onFailure(Call<VkResponse> call, Throwable t) {
                    showError(t.getLocalizedMessage());
                Log.d("onFailure", "onFailure: "+t.getLocalizedMessage());
            }
        });
    }

    private void showError(String message){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }
}
