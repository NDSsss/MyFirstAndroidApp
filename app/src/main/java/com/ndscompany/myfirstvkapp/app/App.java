package com.ndscompany.myfirstvkapp.app;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;
import com.ndscompany.myfirstvkapp.repository.IWallRepository;
import com.ndscompany.myfirstvkapp.repository.WallApiRepository;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends MultiDexApplication {
    private static App mIstance;
    private IWallRepository wallApiRepository;
    private Retrofit mRetrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        mIstance = this;
        Fresco.initialize(this);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.vk.com/method/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
        wallApiRepository = new WallApiRepository(mRetrofit);
    }

    public static App getmIstance() {
        return mIstance;
    }

    public IWallRepository getWallApiRepository() {
        return wallApiRepository;
    }
}
