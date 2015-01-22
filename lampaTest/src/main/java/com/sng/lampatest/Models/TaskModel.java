package com.sng.lampatest.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alexandr on 21.01.2015.
 */
public class TaskModel implements Parcelable {
    private String smallDescription;
    private String fullDescription;

    public TaskModel(String smallDescription, String fullDescription) {
        this.smallDescription = smallDescription;
        this.fullDescription = fullDescription;
    }

    public TaskModel(Parcel in){
        smallDescription = in.readString();
        fullDescription = in.readString();
    }

    public String getSmallDescription() {
        return smallDescription;
    }

    public void setSmallDescription(String smallDescription) {
        this.smallDescription = smallDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(smallDescription);
        dest.writeString(fullDescription);
    }

    public static final Parcelable.Creator<TaskModel> CREATOR = new Parcelable.Creator<TaskModel>() {
        public TaskModel createFromParcel(Parcel in) {
            return new TaskModel(in);
        }

        public TaskModel[] newArray(int size) {
            return new TaskModel[size];
        }
    };
}
