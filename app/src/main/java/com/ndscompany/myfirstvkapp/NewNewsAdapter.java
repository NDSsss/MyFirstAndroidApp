package com.ndscompany.myfirstvkapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class NewNewsAdapter extends RecyclerView.Adapter<NewNewsAdapter.NewNewsViewHolder>{

    private ArrayList<String> news;

    public NewNewsAdapter(ArrayList<String> news){
        this.news = news;
    }

    @NonNull
    @Override
    public NewNewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_news, viewGroup, false);
        NewNewsViewHolder newNewsViewHolder = new NewNewsViewHolder(view);
        return newNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewNewsViewHolder newNewsViewHolder, int position) {
        newNewsViewHolder.tvNumber.setText(String.valueOf(position+1));
        newNewsViewHolder.tvNews.setText(news.get(position));
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    class NewNewsViewHolder extends RecyclerView.ViewHolder{

        TextView tvNews;
        TextView tvNumber;

        public NewNewsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNews = itemView.findViewById(R.id.tv_item_news);
            tvNumber = itemView.findViewById(R.id.tv_item_news_news_count);
        }
    }
}
