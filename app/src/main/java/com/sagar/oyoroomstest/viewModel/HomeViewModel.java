package com.sagar.oyoroomstest.viewModel;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.databinding.BaseObservable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.ActivityHomeBinding;
import com.sagar.oyoroomstest.fragment.BookingsFragment;
import com.sagar.oyoroomstest.fragment.HelpFragment;
import com.sagar.oyoroomstest.fragment.HomeFragment;
import com.sagar.oyoroomstest.fragment.InviteAndEarnFragment;
import com.sagar.oyoroomstest.fragment.OfferFragment;
import com.sagar.oyoroomstest.utils.ActivityController;
import com.sagar.oyoroomstest.utils.CommonUtils;
import com.sagar.oyoroomstest.view.AddHotelActivity;
import com.sagar.oyoroomstest.view.DetailsActivity;
import com.sagar.oyoroomstest.view.HomeActivity;

public class HomeViewModel extends BaseObservable implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener{
    private Fragment myFragment;
    private final HomeActivity activity;
    private final ActivityHomeBinding binding;

    public HomeViewModel(HomeActivity activity, ActivityHomeBinding binding) {
        this.activity = activity;
        this.binding = binding;
        setupNavigationDrawer();
        loadHomeFragment();
    }

    private void loadHomeFragment() {
        myFragment = new HomeFragment();
        CommonUtils.setFragment(myFragment, true, activity, R.id.fragmentContainer, HomeFragment.class.getSimpleName());
    }

    private void setupNavigationDrawer() {
        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                activity, binding.drawerLayout, binding.imageViewDrawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();*/

        binding.bottomNavigation.setOnItemSelectedListener(this::onNavigationItemSelected);
        Menu nav_Menu = binding.navigationView.getMenu();
        binding.navigationView.setNavigationItemSelectedListener(menuItem -> {
            binding.drawerLayout.closeDrawers();

            switch (menuItem.getItemId()) {
                case R.id.oyo_money:
                    //startActivity(new Intent(getApplicationContext(), NotificationList.class));
                    break;
                case R.id.oyo_rupee:
                    //
                    break;
            }

            return true;
        });
    }

    @SuppressLint("NonConstantResourceId")
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_home:
                loadHomeFragment();
                return true;
            case R.id.booking:
                /*myFragment = new DoctorSearchPatientFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable(AppConstant.USER_DATA, AppConstant.homeResponse);
                CommonUtils.setFragment(myFragment, true, activity, R.id.fragmentContainer, DoctorSearchPatientFragment.class.getSimpleName());
                myFragment.setArguments(bundle2);*/

                myFragment = new BookingsFragment();
                CommonUtils.setFragment(myFragment, true, activity, R.id.fragmentContainer, BookingsFragment.class.getSimpleName());
                return true;

            case R.id.offer:
                myFragment = new OfferFragment();
                CommonUtils.setFragment(myFragment, true, activity, R.id.fragmentContainer, OfferFragment.class.getSimpleName());
                return true;

            case R.id.invite:
                myFragment = new InviteAndEarnFragment();
                CommonUtils.setFragment(myFragment, true, activity, R.id.fragmentContainer, InviteAndEarnFragment.class.getSimpleName());
                return true;

            case R.id.help:
                myFragment = new HelpFragment();
                CommonUtils.setFragment(myFragment, true, activity, R.id.fragmentContainer, HelpFragment.class.getSimpleName());
                return true;
        }
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fabAddHotel:{
                ActivityController.startActivity(activity, AddHotelActivity.class, false, false);
                break;
            }
            case R.id.imageViewDrawer:{
                if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    binding.drawerLayout.closeDrawer(GravityCompat.START);
                }else {
                    binding.drawerLayout.openDrawer(GravityCompat.START);
                }
                break;
            }
        }
    }
}