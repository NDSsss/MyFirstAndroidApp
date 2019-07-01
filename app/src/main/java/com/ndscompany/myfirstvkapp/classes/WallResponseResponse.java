package com.ndscompany.myfirstvkapp.classes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WallResponseResponse implements Parcelable {
    @SerializedName("count")
    private int count;

    @SerializedName("items")
    private ArrayList<News> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<News> getItems() {
        return items;
    }

    public void setItems(ArrayList<News> items) {
        this.items = items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.count);
        dest.writeTypedList(this.items);
    }

    public WallResponseResponse() {
    }

    protected WallResponseResponse(Parcel in) {
        this.count = in.readInt();
        this.items = in.createTypedArrayList(News.CREATOR);
    }

    public static final Parcelable.Creator<WallResponseResponse> CREATOR = new Parcelable.Creator<WallResponseResponse>() {
        @Override
        public WallResponseResponse createFromParcel(Parcel source) {
            return new WallResponseResponse(source);
        }

        @Override
        public WallResponseResponse[] newArray(int size) {
            return new WallResponseResponse[size];
        }
    };
}
