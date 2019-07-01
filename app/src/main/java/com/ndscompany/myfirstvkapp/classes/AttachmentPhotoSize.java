package com.ndscompany.myfirstvkapp.classes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class AttachmentPhotoSize implements Parcelable {
    public static final String ATTACHMENT_PHOTO_SIZE_X = "x";
    public static final String ATTACHMENT_PHOTO_SIZE_Y = "y";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @SerializedName("type")
    private String type;
    @SerializedName("url")
    private String url;
    @SerializedName("width")
    private Integer width;
    @SerializedName("height")
    private Integer height;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeString(this.url);
        dest.writeValue(this.width);
        dest.writeValue(this.height);
    }

    public AttachmentPhotoSize() {
    }

    protected AttachmentPhotoSize(Parcel in) {
        this.type = in.readString();
        this.url = in.readString();
        this.width = (Integer) in.readValue(Integer.class.getClassLoader());
        this.height = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<AttachmentPhotoSize> CREATOR = new Parcelable.Creator<AttachmentPhotoSize>() {
        @Override
        public AttachmentPhotoSize createFromParcel(Parcel source) {
            return new AttachmentPhotoSize(source);
        }

        @Override
        public AttachmentPhotoSize[] newArray(int size) {
            return new AttachmentPhotoSize[size];
        }
    };
}
