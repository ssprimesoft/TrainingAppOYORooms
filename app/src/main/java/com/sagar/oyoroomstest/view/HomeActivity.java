package com.sagar.oyoroomstest.view;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;

import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.ActivityHomeBinding;
import com.sagar.oyoroomstest.viewModel.HomeViewModel;

public class HomeActivity extends AppCompatActivity {
    private HomeViewModel viewModel;
    private ActivityHomeBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        viewModel = new HomeViewModel(this, mBinding);
        mBinding.setViewModel(viewModel);
    }


    @Override
    public void onBackPressed() {
        if (mBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mBinding.drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            ExitApp();
        }
    }

    private void ExitApp() {
        new AlertDialog.Builder(HomeActivity.this)
                .setTitle(getString(R.string.app_name))
                .setMessage(getString(R.string.exit_msg))
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                    HomeActivity.super.onBackPressed();
                    finish();
                })
                .setNegativeButton(android.R.string.no, (dialog, which) -> {
                    // do nothing
                })
                .show();
    }
}