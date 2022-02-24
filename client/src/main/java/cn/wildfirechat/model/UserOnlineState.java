/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.wildfirechat.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heavyrain lee on 2022/2/24.
 */

public class UserOnlineState implements Parcelable {

    public String userId;
    public UserCustomState customState;
    public List<UserClientState> clientStates;

    public UserOnlineState() {
    }

    public UserOnlineState(String userId) {
        this.userId = userId;
    }

    public UserOnlineState(String userId, UserCustomState customState, List<UserClientState> clientStates) {
        this.userId = userId;
        this.customState = customState;
        this.clientStates = clientStates;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userId);
        customState.writeToParcel(dest, flags);
        if(clientStates != null && clientStates.size() > 0) {
            dest.writeInt(clientStates.size());
            for (UserClientState clientState:clientStates) {
                clientState.writeToParcel(dest, flags);
            }
        } else {
            dest.writeInt(0);
        }
    }

    protected UserOnlineState(Parcel in) {
        this.userId = in.readString();
        this.customState = new UserCustomState(in);
        int size = in.readInt();
        this.clientStates = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            UserClientState clientState = new UserClientState(in);
            this.clientStates.add(clientState);
        }
    }

    public static final Creator<UserOnlineState> CREATOR = new Creator<UserOnlineState>() {
        @Override
        public UserOnlineState createFromParcel(Parcel source) {
            return new UserOnlineState(source);
        }

        @Override
        public UserOnlineState[] newArray(int size) {
            return new UserOnlineState[size];
        }
    };
}
