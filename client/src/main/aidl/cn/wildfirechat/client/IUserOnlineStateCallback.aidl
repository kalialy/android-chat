// IConnectionStatusChanged.aidl
package cn.wildfirechat.client;

import cn.wildfirechat.model.UserOnlineState;

interface IUserOnlineStateCallback {
    void onSuccess(in List<UserOnlineState> states);
    void onFailure(in int errorCode);
}
