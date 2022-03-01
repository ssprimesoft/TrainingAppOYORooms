package com.sagar.oyoroomstest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.FragmentBookingsBinding;
import com.sagar.oyoroomstest.databinding.FragmentHomeBinding;
import com.sagar.oyoroomstest.viewModel.BookingsFragmentViewModel;
import com.sagar.oyoroomstest.viewModel.HomeFragmentViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookingsFragment extends Fragment {

    private FragmentBookingsBinding mBinding;
    private BookingsFragmentViewModel viewModel;

    public BookingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookings, container, false);
        viewModel = new BookingsFragmentViewModel(this, mBinding);
        mBinding.setViewModel(viewModel);
        return mBinding.getRoot();
    }
}
