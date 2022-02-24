// IConnectionStatusChanged.aidl
package cn.wildfirechat.client;

import cn.wildfirechat.model.UserOnlineState;

interface IOnlineEventListener {
    void onOnlineEvent(in List<UserOnlineState> states);
}
