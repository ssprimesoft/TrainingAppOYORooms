package com.sagar.oyoroomstest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.FragmentHomeBinding;
import com.sagar.oyoroomstest.databinding.FragmentOfferBinding;
import com.sagar.oyoroomstest.viewModel.HomeFragmentViewModel;
import com.sagar.oyoroomstest.viewModel.OfferFragmentViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class OfferFragment extends Fragment {


    private FragmentOfferBinding mBinding;
    private OfferFragmentViewModel viewModel;

    public OfferFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_offer, container, false);
        viewModel = new OfferFragmentViewModel(this, mBinding);
        mBinding.setViewModel(viewModel);
        return mBinding.getRoot();

    }
}
