package com.sagar.oyoroomstest.viewModel;

import android.view.View;
import androidx.databinding.BaseObservable;
import androidx.lifecycle.ViewModel;

import com.android.volley.toolbox.ImageLoader;
import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.ActivityDetailsBinding;
import com.sagar.oyoroomstest.network.CustomVolleyRequest;
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

        ImageLoader imageLoader = CustomVolleyRequest.getInstance(activity).getImageLoader();
        imageLoader.get(activity.getString(R.string.icon_uri), ImageLoader.getImageListener(binding.imageViewPoster, R.mipmap.ic_launcher, R.mipmap.ic_launcher));
    }

    public void onClick(View v) {
        if (v.getId() == R.id.imageViewBack) {
            activity.onBackPressed();
        }
    }
}