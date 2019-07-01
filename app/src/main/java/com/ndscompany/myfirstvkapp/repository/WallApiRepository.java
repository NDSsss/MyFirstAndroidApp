package com.ndscompany.myfirstvkapp.repository;

import com.ndscompany.myfirstvkapp.classes.News;
import com.ndscompany.myfirstvkapp.classes.WallResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class WallApiRepository implements IWallRepository {

    private ArrayList<String> news;
    private Retrofit mRetrofit;

    public WallApiRepository(Retrofit retrofit) {
        this.mRetrofit = retrofit;
        news = new ArrayList<>();
        news.add("One");
        news.add("Two");
        news.add("Three");
        news.add("Four");
        news.add("Five");
    }

    @Override
    public ArrayList<String> getNews() {
        return news == null? new ArrayList<String>():news;
    }


    @Override
    public void getNewsFromApi(final GetNewsFromApiCallback callback) {
        mRetrofit.create(IWallApiServise.class).getNews("wall.get", getWallsQueryMap()).enqueue(new Callback<WallResponse>() {
            @Override
            public void onResponse(Call<WallResponse> call, Response<WallResponse> response) {
                if(response.isSuccessful()){
                    callback.setNews(response.body().getResponse().getItems());
                } else {
                    callback.error("Response error");
                }
            }

            @Override
            public void onFailure(Call<WallResponse> call, Throwable t) {
                callback.error(t.getLocalizedMessage());
            }
        });
    }

    private Map<String, String> getWallsQueryMap(){
        Map<String,String> queryMap = new HashMap<>();
        queryMap.put("owner_id","-154090709");
        queryMap.put("domain","kimkfu");
        queryMap.put("count","10");
        queryMap.put("filter","owner");
        queryMap.put("extended","0");
        queryMap.put("v","5.100");
        queryMap.put("access_token","293265a0293265a0293265a0d8295909bc22932293265a0742b992ec3a28b7cfcada41c");
        return queryMap;
    }
}
