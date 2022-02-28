package com.sagar.oyoroomstest.viewModel;
import android.animation.ObjectAnimator;
import android.os.Handler;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.ViewModel;

import com.sagar.oyoroomstest.databinding.ActivitySplashBinding;
import com.sagar.oyoroomstest.utils.ActivityController;
import com.sagar.oyoroomstest.view.HomeActivity;
import com.sagar.oyoroomstest.view.SplashActivity;

public class SplashViewModel extends ViewModel {
    private static final int SPLASH_TIME_OUT = 2000;
    private final SplashActivity activity;
    private final ActivitySplashBinding binding;
    public SplashViewModel(SplashActivity activity, ActivitySplashBinding binding) {
        this.activity = activity;
        this.binding = binding;
        playProgress();
        decideNextActivity();
    }

    //Method to run progress bar for 5 seconds
    private void playProgress() {
        ObjectAnimator.ofInt(binding.splashProgress, "progress", 100)
                .setDuration(SPLASH_TIME_OUT)
                .start();
    }

    private void decideNextActivity() {
        new Handler().postDelayed(() -> {
            ActivityController.startActivity(activity, HomeActivity.class, true, true);
            activity.finish();
        }, SPLASH_TIME_OUT);
    }
}