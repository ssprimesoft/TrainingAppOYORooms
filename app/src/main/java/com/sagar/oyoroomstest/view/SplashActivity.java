package com.sagar.oyoroomstest.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.ActivitySplashBinding;
import com.sagar.oyoroomstest.viewModel.SplashViewModel;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        SplashViewModel viewModel = new SplashViewModel(this, mBinding);
        mBinding.setViewModel(viewModel);
    }
}