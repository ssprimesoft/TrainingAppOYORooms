package com.sagar.oyoroomstest.viewModel;

import android.view.View;

import androidx.databinding.BaseObservable;

import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.FragmentOfferBinding;
import com.sagar.oyoroomstest.fragment.OfferFragment;
import com.sagar.oyoroomstest.utils.ActivityController;
import com.sagar.oyoroomstest.view.SearchActivity;

public class OfferFragmentViewModel extends BaseObservable implements View.OnClickListener {

    private final OfferFragment fragment;
    private final FragmentOfferBinding mBinding;

    public OfferFragmentViewModel(OfferFragment fragment, FragmentOfferBinding mBinding) {
        this.fragment = fragment;
        this.mBinding = mBinding;
    }

    public void onClick(View v) {
        if (v.getId() == R.id.layoutSearch) {
            ActivityController.startActivity(fragment.getActivity(), SearchActivity.class, false, false);
        }
    }
}
