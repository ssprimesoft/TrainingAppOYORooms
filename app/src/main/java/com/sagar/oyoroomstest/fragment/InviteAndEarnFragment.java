package com.sagar.oyoroomstest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.FragmentHomeBinding;
import com.sagar.oyoroomstest.databinding.FragmentInviteAndEarnBinding;
import com.sagar.oyoroomstest.viewModel.HomeFragmentViewModel;
import com.sagar.oyoroomstest.viewModel.InviteAndEarnFragmentViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class InviteAndEarnFragment extends Fragment {

    private FragmentInviteAndEarnBinding mBinding;
    private InviteAndEarnFragmentViewModel viewModel;

    public InviteAndEarnFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_invite_and_earn, container, false);
        viewModel = new InviteAndEarnFragmentViewModel(this, mBinding);
        mBinding.setViewModel(viewModel);
        return mBinding.getRoot();

    }
}
