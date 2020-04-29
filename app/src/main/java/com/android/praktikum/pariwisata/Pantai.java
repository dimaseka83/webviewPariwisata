package com.android.praktikum.pariwisata;

import android.os.Parcel;
import android.os.Parcelable;

class Pantai implements Parcelable {
    private String nameBeach;
    private String Website;
    private int photo;

    public Pantai(){

    }

    protected Pantai(Parcel in) {
        nameBeach = in.readString();
        Website = in.readString();
        photo = in.readInt();
    }

    public static final Creator<Pantai> CREATOR = new Creator<Pantai>() {
        @Override
        public Pantai createFromParcel(Parcel in) {
            return new Pantai(in);
        }

        @Override
        public Pantai[] newArray(int size) {
            return new Pantai[size];
        }
    };

    public String getNameBeach() {
        return nameBeach;
    }

    public void setNameBeach(String nameBeach) {
        this.nameBeach = nameBeach;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameBeach);
        dest.writeString(Website);
        dest.writeInt(photo);
    }
}
