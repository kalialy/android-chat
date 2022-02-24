/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.wildfirechat.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/**
 * Created by heavyrain lee on 2022/2/24.
 */

public class UserCustomState implements Parcelable {

    public int state;
    public String text;

    public UserCustomState() {
    }

    public UserCustomState(int state, String text) {
        this.state = state;
        this.text = text;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.state);
        dest.writeString(TextUtils.isEmpty(text)?"":text);
    }

    protected UserCustomState(Parcel in) {
        this.state = in.readInt();
        this.text = in.readString();
    }

    public static final Creator<UserCustomState> CREATOR = new Creator<UserCustomState>() {
        @Override
        public UserCustomState createFromParcel(Parcel source) {
            return new UserCustomState(source);
        }

        @Override
        public UserCustomState[] newArray(int size) {
            return new UserCustomState[size];
        }
    };
}
