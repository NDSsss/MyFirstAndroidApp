package com.ndscompany.myfirstvkapp.classes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AttachmentAlbumThumb implements Parcelable {
    @SerializedName("sizes")
    private ArrayList<AttachmentPhotoSize> sizes;

    public ArrayList<AttachmentPhotoSize> getSizes() {
        return sizes;
    }

    public void setSizes(ArrayList<AttachmentPhotoSize> sizes) {
        this.sizes = sizes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.sizes);
    }

    public AttachmentAlbumThumb() {
    }

    protected AttachmentAlbumThumb(Parcel in) {
        this.sizes = in.createTypedArrayList(AttachmentPhotoSize.CREATOR);
    }

    public static final Parcelable.Creator<AttachmentAlbumThumb> CREATOR = new Parcelable.Creator<AttachmentAlbumThumb>() {
        @Override
        public AttachmentAlbumThumb createFromParcel(Parcel source) {
            return new AttachmentAlbumThumb(source);
        }

        @Override
        public AttachmentAlbumThumb[] newArray(int size) {
            return new AttachmentAlbumThumb[size];
        }
    };
}
