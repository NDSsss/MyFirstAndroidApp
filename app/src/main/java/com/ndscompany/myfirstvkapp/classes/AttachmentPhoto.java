package com.ndscompany.myfirstvkapp.classes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AttachmentPhoto implements Parcelable {
    @SerializedName("sizes")
    private ArrayList<AttachmentPhotoSize> sizes;

    public ArrayList<AttachmentPhotoSize> getSizes() {
        return sizes;
    }

    public void setSizes(ArrayList<AttachmentPhotoSize> sizes) {
        this.sizes = sizes;
    }

    public AttachmentPhoto() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.sizes);
    }

    protected AttachmentPhoto(Parcel in) {
        this.sizes = in.createTypedArrayList(AttachmentPhotoSize.CREATOR);
    }

    public static final Creator<AttachmentPhoto> CREATOR = new Creator<AttachmentPhoto>() {
        @Override
        public AttachmentPhoto createFromParcel(Parcel source) {
            return new AttachmentPhoto(source);
        }

        @Override
        public AttachmentPhoto[] newArray(int size) {
            return new AttachmentPhoto[size];
        }
    };
}
