package com.sagar.oyoroomstest.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.ActivityDetailsBinding;
import com.sagar.oyoroomstest.viewModel.DetailsViewModel;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailsBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        DetailsViewModel viewModel = new DetailsViewModel(this, mBinding, getIntent().getExtras());
        mBinding.setViewModel(viewModel);
    }
}