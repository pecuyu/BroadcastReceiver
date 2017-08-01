package com.yu.broadcastreceiver;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

import com.yu.broadcastreceiver.receiver.ForceOfflineReceiver;

/**
 * Created by D22436 on 2017/8/1.
 */

public class BaseActivity extends AppCompatActivity {
    private LocalBroadcastManager localBroadcastManager = null;
    private ForceOfflineReceiver forceOfflineReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        ActivityCollector.addActivity(this);

    }

    @Override
    protected void onResume() { // 处于前台时注册
        super.onResume();

        IntentFilter filter = new IntentFilter();
        filter.addAction("com.yu.broadcastreceiver.FORCE_OFFLINE");
        forceOfflineReceiver = new ForceOfflineReceiver();
        localBroadcastManager.registerReceiver(forceOfflineReceiver, filter);
    }

    @Override
    protected void onPause() {      // 不处于前台则取消注册
        super.onPause();
        localBroadcastManager.unregisterReceiver(forceOfflineReceiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }


}
