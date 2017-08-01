package com.yu.broadcastreceiver;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by D22436 on 2017/8/1.
 */

public class ActivityCollector {
    private static  List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * 结束所有Activity
     */
    public static void finishAll() {
        for (Activity activity:activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
            activities.remove(activity);
        }
    }

}
