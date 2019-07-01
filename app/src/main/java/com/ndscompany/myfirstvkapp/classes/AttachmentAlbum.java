package com.ndscompany.myfirstvkapp.classes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class AttachmentAlbum implements Parcelable {
    @SerializedName("thumb")
    private AttachmentAlbumThumb thumb;

    public AttachmentAlbumThumb getThumb() {
        return thumb;
    }

    public void setThumb(AttachmentAlbumThumb thumb) {
        this.thumb = thumb;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.thumb, flags);
    }

    public AttachmentAlbum() {
    }

    protected AttachmentAlbum(Parcel in) {
        this.thumb = in.readParcelable(AttachmentAlbumThumb.class.getClassLoader());
    }

    public static final Parcelable.Creator<AttachmentAlbum> CREATOR = new Parcelable.Creator<AttachmentAlbum>() {
        @Override
        public AttachmentAlbum createFromParcel(Parcel source) {
            return new AttachmentAlbum(source);
        }

        @Override
        public AttachmentAlbum[] newArray(int size) {
            return new AttachmentAlbum[size];
        }
    };
}
