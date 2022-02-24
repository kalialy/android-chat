/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.wildfirechat.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by heavyrain lee on 2022/2/24.
 */

public class UserClientState implements Parcelable {


    public int platform;
    public int state;
    public long lastSeen;

    public UserClientState() {
    }

    public UserClientState(int platform, int state, long lastSeen) {
        this.platform = platform;
        this.state = state;
        this.lastSeen = lastSeen;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.platform);
        dest.writeInt(this.state);
        dest.writeLong(this.lastSeen);
    }

    protected UserClientState(Parcel in) {
        this.platform = in.readInt();
        this.state = in.readInt();
        this.lastSeen = in.readLong();
    }

    public static final Creator<UserClientState> CREATOR = new Creator<UserClientState>() {
        @Override
        public UserClientState createFromParcel(Parcel source) {
            return new UserClientState(source);
        }

        @Override
        public UserClientState[] newArray(int size) {
            return new UserClientState[size];
        }
    };
}
