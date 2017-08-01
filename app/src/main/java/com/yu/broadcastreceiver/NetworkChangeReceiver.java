package com.yu.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by D22436 on 2017/8/1.
 * 监听网络变化的广播接收者
 */

public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case "android.net.conn.CONNECTIVITY_CHANGE":
                Log.e("TAG", "android.net.conn.CONNECTIVITY_CHANGE");
                // 获取网络管理连接类ConnectivityManager
                ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                // 获取网络信息
                NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    Log.e("TAG", "network is available");
                } else {
                    Log.e("TAG", "network is not available");
                }
                break;

        }

    }
}
