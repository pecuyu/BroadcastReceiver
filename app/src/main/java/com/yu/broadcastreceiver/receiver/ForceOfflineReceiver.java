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
                                ActivityCollector.finishAll();
                                Intent i = new Intent(context, LoginActivity.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                context.startActivity(i);
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
                dialog.show();
                break;
        }
    }
}
