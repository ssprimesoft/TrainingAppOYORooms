package com.sagar.oyoroomstest.viewModel;

import android.view.View;

import androidx.databinding.BaseObservable;

import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.FragmentHelpBinding;
import com.sagar.oyoroomstest.fragment.HelpFragment;
import com.sagar.oyoroomstest.utils.ActivityController;
import com.sagar.oyoroomstest.view.SearchActivity;

public class HelpFragmentViewModel extends BaseObservable implements View.OnClickListener {
    private final HelpFragment fragment;
    private final FragmentHelpBinding mBinding;

    public HelpFragmentViewModel(HelpFragment fragment, FragmentHelpBinding mBinding) {
        this.fragment = fragment;
        this.mBinding = mBinding;
    }


    public void onClick(View v) {
        if (v.getId() == R.id.layoutSearch) {
            ActivityController.startActivity(fragment.getActivity(), SearchActivity.class, false, false);
        }
    }
}
