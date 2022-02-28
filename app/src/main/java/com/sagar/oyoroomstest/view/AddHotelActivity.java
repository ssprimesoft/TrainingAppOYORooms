package com.sagar.oyoroomstest.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.ActivityAddHotelBinding;
import com.sagar.oyoroomstest.viewModel.AddHotelViewModel;
import com.sagar.oyoroomstest.viewModel.DetailsViewModel;

public class AddHotelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddHotelBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_hotel);
        AddHotelViewModel viewModel = new AddHotelViewModel(this, mBinding);
        mBinding.setViewModel(viewModel);
    }
}