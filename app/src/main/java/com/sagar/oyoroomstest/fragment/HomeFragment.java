package com.sagar.oyoroomstest.fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.FragmentHomeBinding;
import com.sagar.oyoroomstest.viewModel.HomeFragmentViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private FragmentHomeBinding mBinding;
    private HomeFragmentViewModel viewModel;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        viewModel = new HomeFragmentViewModel(this, mBinding);
        mBinding.setViewModel(viewModel);
        return mBinding.getRoot();

    }

    @Override
    public void onPause() {
        super.onPause();
        viewModel.handler.removeCallbacks(viewModel.runnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.handler.postDelayed(viewModel.runnable, viewModel.delay);
    }
}
