package com.sagar.oyoroomstest.viewModel;

import androidx.databinding.BaseObservable;

import com.sagar.oyoroomstest.databinding.ActivityDetailsBinding;
import com.sagar.oyoroomstest.databinding.ActivityHomeBinding;
import com.sagar.oyoroomstest.databinding.ActivitySearchBinding;
import com.sagar.oyoroomstest.view.DetailsActivity;
import com.sagar.oyoroomstest.view.SearchActivity;

public class SearchViewModel extends BaseObservable {
    private SearchActivity activity;
    private ActivitySearchBinding binding;

    public SearchViewModel(SearchActivity activity, ActivitySearchBinding binding) {
        this.activity = activity;
        this.binding = binding;
        setToolbar();
        initialiseComponants();
    }

    private void setToolbar() {
        binding.toolbar.imageViewBack.setOnClickListener(v -> activity.onBackPressed());
        binding.toolbar.textViewToolbarName.setText("Search");
    }

    private void initialiseComponants() {

    }
}