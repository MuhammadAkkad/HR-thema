package com.example.hr_thema.navigationDrawer;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hr_thema.R;
import com.example.hr_thema.detail.chooseOperation.ChooseOperationActivity;
import com.example.hr_thema.detail.DetailFragment;
import com.example.hr_thema.bottomNav.lastActivities.LastActivitiesFragment;
import com.example.hr_thema.bottomNav.menu.MenuFragment;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.infideap.drawerbehavior.AdvanceDrawerLayout;

public class NavigationDrawer extends AppCompatActivity implements IDrawerListener, NavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView navigation;
    ImageView usrImg;
    BottomNavigationView bottomNavigationView;
    View v;
    private AdvanceDrawerLayout drawer;

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
        drawer.setViewScale(Gravity.START, 0);
        drawer.setRadius(Gravity.START, 0);
        drawer.setViewElevation(Gravity.START, 30);

        // TODO: Homefragment deleted repace with home activity
        loadFragment(new LastActivitiesFragment());

        navigation = findViewById(R.id.bottom_navigation);
        navigation.setItemIconTintList(null);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.navigation_home) {
                    // TODO: notification implementation test
                    BadgeDrawable badgeDrawable = navigation.getOrCreateBadge(R.id.navigation_home);
                    badgeDrawable.setBackgroundColor(Color.rgb(157, 204, 82));
                    badgeDrawable.setNumber(51);

                    loadFragment(new LastActivitiesFragment());
                    return true;
                } else if (id == R.id.navigation_menu) {
                    loadFragment(new MenuFragment());
                    return true;
                } else if (id == R.id.navigation_notifications) {
                    loadFragment(new DetailFragment());
                    return true;
                } else if (id == R.id.navigation_settings) {
                    Intent i = new Intent(getApplicationContext(), ChooseOperationActivity.class);
                    startActivity(i);
                    return true;
                }
                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, NavigationDrawer.class);
        startActivity(i);
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
}
