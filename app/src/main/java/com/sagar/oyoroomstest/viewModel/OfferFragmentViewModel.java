package com.sagar.oyoroomstest.viewModel;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.adapter.HotelListAdapter;
import com.sagar.oyoroomstest.databinding.FragmentOfferBinding;
import com.sagar.oyoroomstest.fragment.OfferFragment;
import com.sagar.oyoroomstest.model.HotelListData;
import com.sagar.oyoroomstest.model.SliderImageListData;
import com.sagar.oyoroomstest.utils.ActivityController;
import com.sagar.oyoroomstest.view.DetailsActivity;
import com.sagar.oyoroomstest.view.SearchActivity;

import java.util.ArrayList;
import java.util.List;

public class OfferFragmentViewModel extends BaseObservable implements View.OnClickListener {

    private final OfferFragment fragment;
    private final FragmentOfferBinding mBinding;
    private final List<HotelListData> hotelListData = new ArrayList<>();
    private DatabaseReference databaseReference;
    public FirebaseDatabase firebaseDatabase;

    public OfferFragmentViewModel(OfferFragment fragment, FragmentOfferBinding mBinding) {
        this.fragment = fragment;
        this.mBinding = mBinding;
        setPartners();
    }

    private void setPartners() {
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReferenceFromUrl(fragment.getActivity().getString(R.string.firebase_referance_uri));
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

                    mBinding.rvPartnerList.setLayoutManager(new LinearLayoutManager(fragment.getActivity(), LinearLayoutManager.HORIZONTAL, false));

                    hotelListData.add(new HotelListData(id, name, poster, location));
                    HotelListAdapter adapter = new HotelListAdapter(fragment.getActivity(), hotelListData, (view, position) -> {
                        if (view.getId() == R.id.cardViewHotel) {
                            ActivityController.startActivity(fragment.getActivity(), DetailsActivity.class, false, false);
                        }
                    });
                    mBinding.rvPartnerList.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }

    public void onClick(View v) {
        if (v.getId() == R.id.layoutSearch) {
            ActivityController.startActivity(fragment.getActivity(), SearchActivity.class, false, false);
        }
    }
}
