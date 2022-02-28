package com.sagar.oyoroomstest.viewModel;

import android.view.View;

import androidx.databinding.BaseObservable;

import com.android.volley.toolbox.ImageLoader;
import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.ActivityAddHotelBinding;
import com.sagar.oyoroomstest.databinding.ActivityDetailsBinding;
import com.sagar.oyoroomstest.network.CustomVolleyRequest;
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

        ImageLoader imageLoader = CustomVolleyRequest.getInstance(activity).getImageLoader();
        imageLoader.get(activity.getString(R.string.icon_uri), ImageLoader.getImageListener(binding.imageViewPoster, R.mipmap.ic_launcher, R.mipmap.ic_launcher));
    }

    public void onClick(View v) {
        if (v.getId() == R.id.imageViewBack) {
            activity.onBackPressed();
        }
    }
}