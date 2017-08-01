package com.yu.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by D22436 on 2017/8/1.
 * 监听完全开机广播
 */

public class BootCompletedReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case "android.intent.action.BOOT_COMPLETED":
                Log.e("TAG", "BOOT_COMPLETED");
                // 执行相关操作
//                Intent i = new Intent();
//                i.setAction(Intent.ACTION_VIEW);
//                i.setData(Uri.parse("http://www.baidu.com"));
//                context.startActivity(i);  //　打開网页
                break;

        }
    }
}
