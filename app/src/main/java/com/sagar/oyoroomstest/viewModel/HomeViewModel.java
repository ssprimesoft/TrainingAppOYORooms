package com.sagar.oyoroomstest.viewModel;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.databinding.BaseObservable;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.sagar.oyoroomstest.R;
import com.sagar.oyoroomstest.databinding.ActivityHomeBinding;
import com.sagar.oyoroomstest.fragment.HomeFragment;
import com.sagar.oyoroomstest.utils.ActivityController;
import com.sagar.oyoroomstest.utils.CommonUtils;
import com.sagar.oyoroomstest.view.AddHotelActivity;
import com.sagar.oyoroomstest.view.DetailsActivity;
import com.sagar.oyoroomstest.view.HomeActivity;

public class HomeViewModel extends BaseObservable implements View.OnClickListener{
    public Fragment myFragment;
    private HomeActivity activity;
    private ActivityHomeBinding binding;

    public HomeViewModel(HomeActivity activity, ActivityHomeBinding binding) {
        this.activity = activity;
        this.binding = binding;
        loadHomeFragment();
        setupNavigationDrawer();
    }

    private void loadHomeFragment() {
        myFragment = new HomeFragment();
        CommonUtils.setFragment(myFragment, false, activity, R.id.fragmentContainer, HomeFragment.class.getSimpleName());
    }

    private void setupNavigationDrawer() {
        activity.setSupportActionBar(binding.toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                activity, binding.drawerLayout, binding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Menu nav_Menu = binding.navigationView.getMenu();
        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
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
            }
        });
    }

    public void onClick(View v) {
        if (v.getId() == R.id.fabAddHotel) {
            ActivityController.startActivity(activity, AddHotelActivity.class, false, false);
        }
    }
}