package com.yu.broadcastreceiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class LocalReceiver extends BroadcastReceiver {
    public LocalReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case "com.yu.broadcastreceiver.local_receiver":
                Toast.makeText(context, "com.yu.broadcastreceiver.local_receiver", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
