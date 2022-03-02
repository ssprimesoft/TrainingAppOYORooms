package com.sagar.oyoroomstest.viewModel;

import android.os.Bundle;
import android.view.View;
import androidx.databinding.BaseObservable;
import androidx.lifecycle.ViewModel;

import com.android.volley.toolbox.ImageLoader;
import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.ActivityDetailsBinding;
import com.sagar.oyoroomstest.model.HotelListData;
import com.sagar.oyoroomstest.network.CustomVolleyRequest;
import com.sagar.oyoroomstest.view.DetailsActivity;

public class DetailsViewModel extends BaseObservable {
    private final DetailsActivity activity;
    private final ActivityDetailsBinding binding;

    public DetailsViewModel(DetailsActivity activity, ActivityDetailsBinding binding, Bundle bundle) {
        this.activity = activity;
        this.binding = binding;
        initialiseComponents(bundle);
    }

    private void initialiseComponents(Bundle bundle) {

        if (bundle != null) {
            HotelListData hotelListData = (HotelListData) bundle.getSerializable("Data");
            binding.textViewHotelName.setText(hotelListData.getName());
            binding.textViewHotelAddress.setText(hotelListData.getLocation());
            binding.textViewHotelLocation.setText(hotelListData.getLocation());

            ImageLoader imageLoader = CustomVolleyRequest.getInstance(activity).getImageLoader();
            imageLoader.get(hotelListData.getPoster(), ImageLoader.getImageListener(binding.imageViewPoster, R.mipmap.ic_launcher, R.mipmap.ic_launcher));

        }
    }

    public void onClick(View v) {
        if (v.getId() == R.id.imageViewBack) {
            activity.onBackPressed();
        }
    }
}