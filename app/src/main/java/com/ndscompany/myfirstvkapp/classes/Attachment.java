package com.ndscompany.myfirstvkapp.classes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Attachment implements Parcelable {
    public static final String ATTACHMENT_PHOTO = "photo";
    public static final String ATTACHMENT_ALBUM = "album";
    @SerializedName("type")
    private String type;

    @SerializedName(ATTACHMENT_PHOTO)
    private AttachmentPhoto photo;

    @SerializedName("album")
    private AttachmentAlbum album;


    public AttachmentAlbum getAlbum() {
        return album;
    }

    public void setAlbum(AttachmentAlbum album) {
        this.album = album;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AttachmentPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(AttachmentPhoto photo) {
        this.photo = photo;
    }

    public Attachment() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeParcelable(this.photo, flags);
        dest.writeParcelable(this.album, flags);
    }

    protected Attachment(Parcel in) {
        this.type = in.readString();
        this.photo = in.readParcelable(AttachmentPhoto.class.getClassLoader());
        this.album = in.readParcelable(AttachmentAlbum.class.getClassLoader());
    }

    public static final Creator<Attachment> CREATOR = new Creator<Attachment>() {
        @Override
        public Attachment createFromParcel(Parcel source) {
            return new Attachment(source);
        }

        @Override
        public Attachment[] newArray(int size) {
            return new Attachment[size];
        }
    };
}
