package com.sagar.oyoroomstest.viewModel;

import android.os.Bundle;
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
import com.sagar.oyoroomstest.adapter.HotelListAdapter;
import com.sagar.oyoroomstest.adapter.HomeSliderAdapter;
import com.sagar.oyoroomstest.databinding.FragmentHomeBinding;
import com.sagar.oyoroomstest.fragment.HomeFragment;
import com.sagar.oyoroomstest.model.HotelListData;
import com.sagar.oyoroomstest.model.SliderImageListData;
import com.sagar.oyoroomstest.utils.ActivityController;
import com.sagar.oyoroomstest.view.DetailsActivity;
import com.sagar.oyoroomstest.view.SearchActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragmentViewModel extends BaseObservable implements View.OnClickListener {

    private final HomeFragment fragment;
    private final FragmentHomeBinding mBinding;
    private HomeSliderAdapter homeSliderAdapter;

    private final List<SliderImageListData> sliderImageListDataList = new ArrayList<>();
    private final List<HotelListData> hotelListData = new ArrayList<>();
    private int dotscount;
    private ImageView[] dots;
    private int page = 0;
    public Handler handler;
    public int delay = 3000; //milliseconds
    private DatabaseReference databaseReference;
    public FirebaseDatabase firebaseDatabase;

    public Runnable runnable = new Runnable() {
        public void run() {
            try {
                if (homeSliderAdapter.getCount() == page) {
                    page = 0;
                } else {
                    page++;
                }
                mBinding.viewPager.setCurrentItem(page, true);
                handler.postDelayed(this, delay);
            } catch (Exception e) {
                Log.e("pager", e.toString());
            }
        }
    };

    public HomeFragmentViewModel(HomeFragment fragment, FragmentHomeBinding mBinding) {
        this.fragment = fragment;
        this.mBinding = mBinding;
        setUpSlider();
        setUpList();
    }

    private void setUpList() {
        databaseReference.child("Hotels").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                hotelListData.clear();
                for (DataSnapshot child : dataSnapshot.getChildren()) {

                    String id = "id";
                    String location = "location";
                    String name = "name";
                    String poster = "poster";

                    try{
                        id = child.child("id").getValue().toString();
                        location = child.child("location").getValue().toString();
                        name = child.child("name").getValue().toString();
                        poster = child.child("poster").getValue().toString();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    mBinding.rvHotelList.setHasFixedSize(true);

                    hotelListData.add(new HotelListData(id, name, poster, location));
                    HotelListAdapter adapter = new HotelListAdapter(fragment.getActivity(), hotelListData, (view, position) -> {
                        if (view.getId() == R.id.cardViewHotel) {
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("Data", hotelListData.get(position));
                            ActivityController.startActivity(fragment.getActivity(), DetailsActivity.class, bundle, false);
                        }
                    });
                    mBinding.rvHotelList.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void setUpSlider() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReferenceFromUrl(fragment.getActivity().getString(R.string.firebase_referance_uri));
        databaseReference.child("Slider").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                sliderImageListDataList.clear();
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    String id = child.child("id").getValue().toString();
                    String img = child.child("img").getValue().toString();
                    sliderImageListDataList.add(new SliderImageListData(id, img));
                }
                homeSliderAdapter = new HomeSliderAdapter(sliderImageListDataList, fragment.getActivity());
                mBinding.viewPager.setAdapter(homeSliderAdapter);
                dotscount = homeSliderAdapter.getCount();
                dots = new ImageView[dotscount];
                for (int i = 0; i < dotscount; i++) {
                    try {
                        dots[i] = new ImageView(fragment.getActivity());
                        dots[i].setImageDrawable(ContextCompat.getDrawable(fragment.getActivity(), R.drawable.icon2));
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                        params.setMargins(0, 0, 0, 0);
                        mBinding.SliderDots.addView(dots[i], params);
                    } catch (Exception e) {
                        Log.e("HomeFragment", e.toString());
                    }
                }
                if (dotscount > 0) {
                    try {
                        dots[0].setImageDrawable(ContextCompat.getDrawable(fragment.getActivity(), R.drawable.icon1));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        handler = new Handler();
        mBinding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(fragment.getActivity(), R.drawable.icon2));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(fragment.getActivity(), R.drawable.icon1));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void onClick(View v) {
        if (v.getId() == R.id.layoutSearch) {
            ActivityController.startActivity(fragment.getActivity(), SearchActivity.class, false, false);
        }
    }
}
