package com.sagar.oyoroomstest.utils;

import android.util.Log;

import androidx.databinding.library.baseAdapters.BuildConfig;

/**
 * Created by Sagar on 23/02/2022.
 */
public class LogUtils {

    public static void errorLog(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            if (msg != null)
                Log.e(tag, msg);
        }
    }

    public static void infoLog(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void debugLog(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void verboseLog(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            Log.v(tag, msg);
        }
    }
}
