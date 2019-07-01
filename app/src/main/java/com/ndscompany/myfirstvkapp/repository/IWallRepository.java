package com.ndscompany.myfirstvkapp.repository;

import com.ndscompany.myfirstvkapp.classes.News;

import java.util.ArrayList;

public interface IWallRepository {
    public ArrayList<String> getNews();
    void getNewsFromApi(GetNewsFromApiCallback callback);
    interface GetNewsFromApiCallback{
        void setNews(ArrayList<News> news);
        void error(String message);
    }
}
