/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.wildfirechat.remote;

import java.util.List;

import cn.wildfirechat.model.UserOnlineState;

public interface WatchOnlineStateCallback {
    void onSuccess(List<UserOnlineState> onlineStates);

    void onFail(int errorCode);
}
