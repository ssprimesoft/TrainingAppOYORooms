package com.sagar.oyoroomstest.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.ActivitySearchBinding;
import com.sagar.oyoroomstest.viewModel.SearchViewModel;

public class SearchActivity extends AppCompatActivity {
    private SearchViewModel viewModel;
    private ActivitySearchBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        viewModel = new SearchViewModel(this, mBinding);
        mBinding.setViewModel(viewModel);
    }
}