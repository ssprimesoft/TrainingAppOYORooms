package com.sagar.oyoroomstest.viewModel;

import android.view.View;
import androidx.databinding.BaseObservable;
import androidx.lifecycle.ViewModel;

import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.ActivityDetailsBinding;
import com.sagar.oyoroomstest.view.DetailsActivity;

public class DetailsViewModel extends BaseObservable {
    private DetailsActivity activity;
    private ActivityDetailsBinding binding;

    public DetailsViewModel(DetailsActivity activity, ActivityDetailsBinding binding) {
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