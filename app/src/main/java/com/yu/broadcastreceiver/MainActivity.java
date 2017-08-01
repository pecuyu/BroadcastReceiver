package com.yu.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NetworkChangeReceiver mReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerNetworkChangeReceiver();
    }

    /**
     * 注册网络变化的监听器
     */
    private void registerNetworkChangeReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        mReceiver = new NetworkChangeReceiver();
        registerReceiver(mReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver); // 取消注册

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
}
