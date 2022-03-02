package com.sagar.oyoroomstest.viewModel;
import android.view.View;
import androidx.databinding.BaseObservable;
import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.FragmentBookingsBinding;
import com.sagar.oyoroomstest.fragment.BookingsFragment;
import com.sagar.oyoroomstest.utils.ActivityController;
import com.sagar.oyoroomstest.view.SearchActivity;

public class BookingsFragmentViewModel extends BaseObservable implements View.OnClickListener {

    private final BookingsFragment fragment;
    private final FragmentBookingsBinding mBinding;

    public BookingsFragmentViewModel(BookingsFragment fragment, FragmentBookingsBinding mBinding) {
        this.fragment = fragment;
        this.mBinding = mBinding;
    }

    public void onClick(View v) {
        if (v.getId() == R.id.layoutSearch) {
            ActivityController.startActivity(fragment.getActivity(), SearchActivity.class, false, false);
        }
    }
}
