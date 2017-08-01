package com.yu.broadcastreceiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by D22436 on 2017/8/1.
 * 有序广播
 */

public class DIYOrderReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case "com.yu.broadcastreceiver.diy_order_receiver":
                Toast.makeText(context, "com.yu.broadcastreceiver.diy_order_receiver", Toast.LENGTH_SHORT).show();
                abortBroadcast(); // 终止该广播的继续传播
                break;
        }
    }
}
