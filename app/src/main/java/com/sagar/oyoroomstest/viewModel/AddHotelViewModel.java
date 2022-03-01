package com.sagar.oyoroomstest.viewModel;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;

import androidx.databinding.BaseObservable;

import com.android.volley.toolbox.ImageLoader;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.ActivityAddHotelBinding;
import com.sagar.oyoroomstest.databinding.ActivityDetailsBinding;
import com.sagar.oyoroomstest.model.HotelListData;
import com.sagar.oyoroomstest.network.CustomVolleyRequest;
import com.sagar.oyoroomstest.utils.StringUtils;
import com.sagar.oyoroomstest.view.AddHotelActivity;
import com.sagar.oyoroomstest.view.DetailsActivity;

import java.util.Objects;

public class AddHotelViewModel extends BaseObservable {
    private AddHotelActivity activity;
    private ActivityAddHotelBinding binding;
    private DatabaseReference databaseReference;
    public FirebaseDatabase firebaseDatabase;

    public AddHotelViewModel(AddHotelActivity activity, ActivityAddHotelBinding binding) {
        this.activity = activity;
        this.binding = binding;
        initialiseComponants();
    }

    private void initialiseComponants() {
        ImageLoader imageLoader = CustomVolleyRequest.getInstance(activity).getImageLoader();
        imageLoader.get(activity.getString(R.string.icon_uri), ImageLoader.getImageListener(binding.imageViewPoster, R.mipmap.ic_launcher, R.mipmap.ic_launcher));


    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageViewBack:{
                activity.onBackPressed();
                break;
            }
            case R.id.buttonAddHotel:{
                if(validateInput()){
                    addHotel();
                }
                break;
            }
        }
    }

    private boolean validateInput() {
        clearError();
        if (TextUtils.isEmpty((Objects.requireNonNull(binding.editTextId.getText()).toString().trim()))){
            binding.textInputLayoutId.setError("ID Required");
            return false;
        }else if(TextUtils.isEmpty((Objects.requireNonNull(binding.editTextName.getText()).toString().trim()))){
            binding.textInputLayoutName.setError("Name Required");
            return false;
        }else if(TextUtils.isEmpty((Objects.requireNonNull(binding.editTextLocation.getText()).toString().trim()))){
            binding.textInputLayoutLocation.setError("Location Required");
            return false;
        }else if(TextUtils.isEmpty((Objects.requireNonNull(binding.editTextPoster.getText()).toString().trim()))){
            binding.textInputLayoutPoster.setError("Poster URL Required");
            return false;
        }
        return true;
    }

    private void clearError() {
        binding.textInputLayoutId.setError(null);
        binding.textInputLayoutName.setError(null);
        binding.textInputLayoutLocation.setError(null);
        binding.textInputLayoutPoster.setError(null);
    }

    private void addHotel() {
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReferenceFromUrl(activity.getString(R.string.firebase_referance_uri));

        HotelListData hotelListData= new HotelListData(binding.editTextId.getText().toString().trim(),
                binding.editTextName.getText().toString().trim(),
                binding.editTextLocation.getText().toString().trim(),
                binding.editTextPoster.getText().toString().trim());
        databaseReference.child("Hotels").child("50").setValue(hotelListData);
    }
}