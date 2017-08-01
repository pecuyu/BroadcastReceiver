package com.yu.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NetworkChangeReceiver mNetworkReceiver;
    LocalReceiver mLocalReceiver;

    LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerNetworkChangeReceiver();
        registerLocalReceiver();
    }

    /**
     * 注册本地广播，本地广播只可动态注册
     */
    private void registerLocalReceiver() {
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.yu.broadcastreceiver.local_receiver");
        mLocalReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(mLocalReceiver, filter);
    }

    /**
     * 注册网络变化的监听器
     */
    private void registerNetworkChangeReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        mNetworkReceiver = new NetworkChangeReceiver();
        registerReceiver(mNetworkReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mNetworkReceiver); // 取消注册
        localBroadcastManager.unregisterReceiver(mLocalReceiver); // 取消注册本地广播

    }

    public void order_receiver(View view) {
        Intent i = new Intent();
        i.setAction("com.yu.broadcastreceiver.diy_order_receiver");
        sendOrderedBroadcast(i,null);
    }

    public void normal_receiver(View view) {
        Intent i = new Intent();
        i.setAction("com.yu.broadcastreceiver.diy_normal_receiver");
        sendBroadcast(i);
    }

    public void local_receiver(View view) {
        Intent intent = new Intent();
        intent.setAction("com.yu.broadcastreceiver.local_receiver");
        localBroadcastManager.sendBroadcast(intent);
    }
}
