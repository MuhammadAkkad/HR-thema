package com.example.hr_thema.navigationDrawer;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.hr_thema.R;

import com.example.hr_thema.home.HomeActivity;
import com.example.hr_thema.home.HomeFragment;
import com.example.hr_thema.lastActivities.LastActiviesFragment;
import com.example.hr_thema.menu.MenuFragment;
import com.example.hr_thema.notification.NotificationFragment;
import com.example.hr_thema.ongoin.OnGoingFragment;
import com.example.hr_thema.settings.SettingsFragment;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
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
        final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawer.setViewScale(Gravity.START, 1);
        drawer.setRadius(Gravity.START, 25);
        drawer.setViewElevation(Gravity.START, 30);

        // TODO: Homefragment deleted repace with home activity
        loadFragment(new HomeFragment());

        navigation = findViewById(R.id.bottom_navigation);
        navigation.setItemIconTintList(null);
        //navigation.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_UNLABELED);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.navigation_home) {
                    // TODO: notification implementation test
                    BadgeDrawable badgeDrawable = navigation.getOrCreateBadge(R.id.navigation_home);
                    badgeDrawable.setBackgroundColor(Color.rgb(157, 204, 82));
                    badgeDrawable.setNumber(51);



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
                    loadFragment(new LastActiviesFragment());
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
        transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        transaction.replace(R.id.nav_home, fragment);
        transaction.commit();
    }

    @Override
    public void OpenDrawer() {
        drawer.openDrawer(GravityCompat.START);
    }

    @Override
    public void openDetail() {
       // HomeFragment HomeFragment = new HomeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        // TODO: Homefragment deleted repace with home activity
        //HomeFragment.openDetailShow(fragmentManager);
    }
    Dialog dialog;
    @Override
    public void openFilters(View view) {

    }
}
