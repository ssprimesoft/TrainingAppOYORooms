package com.sagar.oyoroomstest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.FragmentHelpBinding;
import com.sagar.oyoroomstest.databinding.FragmentHomeBinding;
import com.sagar.oyoroomstest.viewModel.HelpFragmentViewModel;
import com.sagar.oyoroomstest.viewModel.HomeFragmentViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class HelpFragment extends Fragment {


    private FragmentHelpBinding mBinding;
    private HelpFragmentViewModel viewModel;

    public HelpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_help, container, false);
        viewModel = new HelpFragmentViewModel(this, mBinding);
        mBinding.setViewModel(viewModel);
        return mBinding.getRoot();
    }
}
