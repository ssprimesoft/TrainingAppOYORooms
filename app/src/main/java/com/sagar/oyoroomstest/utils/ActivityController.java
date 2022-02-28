package com.sagar.oyoroomstest.utils;

import android.app.Activity;
import android.content.Intent;

import androidx.core.app.ActivityCompat;

/**
 * Created by Sagar on 23/02/2022.
 */

public class ActivityController {

    /**
     * Start activity.
     *
     * @param activity        the activity
     * @param clazz           the clazz
     * @param isClearPrevious the is clear previous
     * @param isClearStack    the is clear stack
     */
    public static void startActivity(Activity activity, Class clazz, boolean isClearPrevious, boolean isClearStack) {
        Intent intent = new Intent(activity, clazz);
        activity.startActivity(intent);
        if (isClearStack)
            ActivityCompat.finishAffinity(activity);
        if (isClearPrevious)
            activity.finish();
    }
}