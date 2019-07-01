package com.ndscompany.myfirstvkapp.repository;

import com.ndscompany.myfirstvkapp.classes.WallResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface IWallApiServise {
    @GET("{method}/")
    Call<WallResponse> getNews(@Path("method") String method, @QueryMap Map<String,String> queryMap);
}
