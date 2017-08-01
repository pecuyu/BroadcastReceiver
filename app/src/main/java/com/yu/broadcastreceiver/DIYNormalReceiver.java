package com.yu.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by D22436 on 2017/8/1.
 * 自定义普通广播
 */

public class DIYNormalReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case "com.yu.broadcastreceiver.diy_normal_receiver":
                Toast.makeText(context, "com.yu.broadcastreceiver.diy_normal_receiver", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
