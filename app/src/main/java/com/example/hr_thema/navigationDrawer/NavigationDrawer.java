package com.example.hr_thema.navigationDrawer;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import android.view.Window;
import android.view.WindowManager;

import android.widget.ImageView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.hr_thema.R;

import com.example.hr_thema.home.HomeFragment;
import com.example.hr_thema.menu.MenuFragment;
import com.example.hr_thema.notification.NotificationFragment;
import com.example.hr_thema.ongoin.OnGoingFragment;
import com.example.hr_thema.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.infideap.drawerbehavior.AdvanceDrawerLayout;

public class NavigationDrawer extends AppCompatActivity implements OnGoingFragment.ListenerOnGoingFragment, IDrawerListener, NavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView navigation;
    ImageView usrImg;
    BottomNavigationView bottomNavigationView;

    private AdvanceDrawerLayout drawer;

    View v;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        v = getWindow().getDecorView().findViewById(R.id.drawer_layout);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawer.setViewScale(Gravity.START, 1);
        drawer.setRadius(Gravity.START, 25);
        drawer.setViewElevation(Gravity.START, 30);




        loadFragment(new HomeFragment());
        //setLightStatusBar(this.findViewById(R.id.drawer_layout).getRootView(), this);
        navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.navigation_home) {
                    //toolbar.setTitle(getResources().getString(R.string.title_home));
                    loadFragment(new HomeFragment());
                    return true;
                } else if (id == R.id.navigation_menu) {
                    //toolbar.setTitle(getResources().getString(R.string.title_category));
                    loadFragment(new MenuFragment());
                    return true;
                } else if (id == R.id.navigation_notifications) {
                    //toolbar.setTitle(getResources().getString(R.string.title_notifications));
                    loadFragment(new NotificationFragment());
                    return true;
                } else if (id == R.id.navigation_settings) {
                    //toolbar.setTitle(getResources().getString(R.string.title_profile));
                    loadFragment(new SettingsFragment());
                    return true;
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_home, fragment);
        transaction.commit();
    }

    @Override
    public void OpenDrawer() {
        drawer.openDrawer(GravityCompat.START);
    }

    @Override
    public void openDetail() {
        HomeFragment homeFragment = new HomeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        homeFragment.openDetailShow(fragmentManager);
    }
    Dialog dialog;
    @Override
    public void openFilters(View view) {

    }
}
