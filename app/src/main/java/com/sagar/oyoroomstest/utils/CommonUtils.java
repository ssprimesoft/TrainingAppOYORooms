package com.sagar.oyoroomstest.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Created by Sagar on 23/02/2022.
 */
public class CommonUtils {

    public static void setFragment(Fragment fragment, boolean removeStack, FragmentActivity activity, int mContainer, String tag) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction ftTransaction = fragmentManager.beginTransaction();
        if (removeStack) {
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            if (tag != null)
                ftTransaction.replace(mContainer, fragment, tag);
            else
                ftTransaction.replace(mContainer, fragment);
        } else {
            if (tag != null)
                ftTransaction.replace(mContainer, fragment, tag);
            else
                ftTransaction.replace(mContainer, fragment);
            ftTransaction.addToBackStack(null);
        }
        ftTransaction.commit();
    }
}
