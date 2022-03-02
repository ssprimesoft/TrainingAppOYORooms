package com.sagar.oyoroomstest.viewModel;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.GravityCompat;
import androidx.databinding.BaseObservable;
import androidx.drawerlayout.widget.DrawerLayout;
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
import com.sagar.oyoroomstest.utils.ToastUtils;
import com.sagar.oyoroomstest.view.AddHotelActivity;
import com.sagar.oyoroomstest.view.DetailsActivity;
import com.sagar.oyoroomstest.view.HomeActivity;

public class HomeViewModel extends BaseObservable implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
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
        setToolbar();
    }

    @SuppressLint("NonConstantResourceId")
    private void setupNavigationDrawer() {
        binding.bottomNavigation.setOnItemSelectedListener(this::onNavigationItemSelected);
        binding.navigationView.setNavigationItemSelectedListener(menuItem -> {
            binding.drawerLayout.closeDrawers();

            switch (menuItem.getItemId()) {
                case R.id.oyo_money:
                    ToastUtils.showToastShort(activity, activity.getString(R.string.under_implementation));
                    break;
                case R.id.oyo_rupee:
                    ToastUtils.showToastShort(activity, activity.getString(R.string.under_implementation));
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
                setToolbar(activity.getString(R.string.bookings));
                myFragment = new BookingsFragment();
                CommonUtils.setFragment(myFragment, true, activity, R.id.fragmentContainer, BookingsFragment.class.getSimpleName());
                return true;

            case R.id.offer:
                setToolbar(activity.getString(R.string.offers));
                myFragment = new OfferFragment();
                CommonUtils.setFragment(myFragment, true, activity, R.id.fragmentContainer, OfferFragment.class.getSimpleName());
                return true;

            case R.id.invite:
                setToolbar(activity.getString(R.string.invite_and_earn));
                myFragment = new InviteAndEarnFragment();
                CommonUtils.setFragment(myFragment, true, activity, R.id.fragmentContainer, InviteAndEarnFragment.class.getSimpleName());
                return true;

            case R.id.help:
                setToolbar(activity.getString(R.string.need_help));
                myFragment = new HelpFragment();
                CommonUtils.setFragment(myFragment, true, activity, R.id.fragmentContainer, HelpFragment.class.getSimpleName());
                return true;
        }
        return true;
    }

    private void setToolbar(String name) {
        binding.relativeLayoutToolbar.setBackgroundColor(activity.getColor(R.color.white));
        binding.textViewToolbarName.setText(name);
        binding.textViewToolbarName.setTextColor(activity.getColor(R.color.black));
        binding.imageViewDrawer.setImageDrawable(AppCompatResources.getDrawable(activity, R.drawable.ic_baseline_arrow_back_24));
        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        binding.fabAddHotel.setVisibility(View.GONE);
        binding.viewToolbarDivider.setVisibility(View.VISIBLE);
    }

    private void setToolbar() {
        binding.relativeLayoutToolbar.setBackgroundColor(activity.getColor(R.color.color_primary_dark));
        binding.textViewToolbarName.setText(activity.getText(R.string.app_name));
        binding.textViewToolbarName.setTextColor(activity.getColor(R.color.white));
        binding.imageViewDrawer.setImageDrawable(AppCompatResources.getDrawable(activity, R.drawable.ic_drawer));
        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        binding.fabAddHotel.setVisibility(View.VISIBLE);
        binding.viewToolbarDivider.setVisibility(View.GONE);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fabAddHotel: {
                ActivityController.startActivity(activity, AddHotelActivity.class, false, false);
                break;
            }
            case R.id.imageViewDrawer: {
                if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    binding.drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    binding.drawerLayout.openDrawer(GravityCompat.START);
                }
                break;
            }
        }
    }
}