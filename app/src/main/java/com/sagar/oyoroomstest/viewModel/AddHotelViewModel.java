package com.sagar.oyoroomstest.viewModel;

import android.view.View;

import androidx.databinding.BaseObservable;

import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.ActivityAddHotelBinding;
import com.sagar.oyoroomstest.databinding.ActivityDetailsBinding;
import com.sagar.oyoroomstest.view.AddHotelActivity;
import com.sagar.oyoroomstest.view.DetailsActivity;

public class AddHotelViewModel extends BaseObservable {
    private AddHotelActivity activity;
    private ActivityAddHotelBinding binding;

    public AddHotelViewModel(AddHotelActivity activity, ActivityAddHotelBinding binding) {
        this.activity = activity;
        this.binding = binding;
        initialiseComponants();
    }

    private void initialiseComponants() {

    }

    public void onClick(View v) {
        if (v.getId() == R.id.imageViewBack) {
            activity.onBackPressed();
        }
    }
}