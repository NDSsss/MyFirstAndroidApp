package com.ndscompany.myfirstvkapp.classes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class WallResponse implements Parcelable {
    @SerializedName("response")
    private WallResponseResponse response;

    public WallResponseResponse getResponse() {
        return response;
    }

    public void setResponse(WallResponseResponse response) {
        this.response = response;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.response, flags);
    }

    public WallResponse() {
    }

    protected WallResponse(Parcel in) {
        this.response = in.readParcelable(WallResponseResponse.class.getClassLoader());
    }

    public static final Parcelable.Creator<WallResponse> CREATOR = new Parcelable.Creator<WallResponse>() {
        @Override
        public WallResponse createFromParcel(Parcel source) {
            return new WallResponse(source);
        }

        @Override
        public WallResponse[] newArray(int size) {
            return new WallResponse[size];
        }
    };
}
