package com.sagar.oyoroomstest.viewModel;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.BaseObservable;
import androidx.viewpager.widget.ViewPager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.adapter.HomeSliderAdapter;
import com.sagar.oyoroomstest.adapter.HotelListAdapter;
import com.sagar.oyoroomstest.databinding.FragmentBookingsBinding;
import com.sagar.oyoroomstest.databinding.FragmentHomeBinding;
import com.sagar.oyoroomstest.fragment.BookingsFragment;
import com.sagar.oyoroomstest.fragment.HomeFragment;
import com.sagar.oyoroomstest.model.HotelListData;
import com.sagar.oyoroomstest.model.SliderImageListData;
import com.sagar.oyoroomstest.utils.ActivityController;
import com.sagar.oyoroomstest.view.DetailsActivity;
import com.sagar.oyoroomstest.view.SearchActivity;

import java.util.ArrayList;
import java.util.List;

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
