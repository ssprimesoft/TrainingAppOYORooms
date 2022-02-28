package com.sagar.oyoroomstest.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Sagar on 23/02/2022.
 */
public class ToastUtils {

    /**
     * context The context
     * message The message
     */
    public static void showToastShort(Context context, String message) {
        if (context != null) {
            if (!StringUtils.isBlank(message))
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * context The context
     * message The message
     */
    public static void showToastLong(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}