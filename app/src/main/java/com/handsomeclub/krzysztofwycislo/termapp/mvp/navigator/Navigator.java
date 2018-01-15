package com.handsomeclub.krzysztofwycislo.termapp.mvp.navigator;

import android.content.Context;
import android.content.Intent;

import com.handsomeclub.krzysztofwycislo.termapp.mvp.base.BaseActivity;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.timeline.TimelineActivity;

/**
 * Created by KrzysztofWycislo on 1/14/2018.
 *
 */

public class Navigator {

    /**
     * Goes to the timeline screen.
     *
     * @param context A Context needed to open the destiny activity.
     */
    public static void navigateToDefaultActivity(Context context) {
        if (context != null) {
            Intent intentToLaunch = TimelineActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }


    /**
     * Goes to the user list screen.
     *
     * @param context A Context needed to open the destiny activity.
     */
    public static void navigateToDeclaredActivity(Context context, Class<? extends BaseActivity> activity) {
        if (context != null) {
            Intent intentToLaunch = new Intent(context, activity);

            intentToLaunch.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intentToLaunch.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            context.startActivity(intentToLaunch);
        }
    }

}
