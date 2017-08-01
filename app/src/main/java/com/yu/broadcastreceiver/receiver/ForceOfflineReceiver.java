package com.yu.broadcastreceiver.receiver;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.WindowManager;

import com.yu.broadcastreceiver.ActivityCollector;
import com.yu.broadcastreceiver.LoginActivity;

/**
 * 强制下线
 */
public class ForceOfflineReceiver extends BroadcastReceiver {
    public ForceOfflineReceiver() {
    }

    @Override
    public void onReceive(final Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case "com.yu.broadcastreceiver.FORCE_OFFLINE":
                Log.e("TAG", "FORCE_OFFLINE");
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("warmming")
                        .setMessage("you are forced offline")
                        .setCancelable(false)
                        .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCollector.finishAll();  // 结束所有Activity
                                Intent i = new Intent(context, LoginActivity.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  // 从非Activity启动Activity需加flag
                                context.startActivity(i); // 从新启动LoginActivity
                            }
                        });
                AlertDialog dialog = builder.create();
                // 弹出系统级对话框
                dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
                dialog.show();
                break;
        }
    }
}
