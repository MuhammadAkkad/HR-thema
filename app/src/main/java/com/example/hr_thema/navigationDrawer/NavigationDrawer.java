package com.example.hr_thema.navigationDrawer;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hr_thema.R;
import com.example.hr_thema.bottomNav.lastActivities.LastActivitiesFragment;
import com.example.hr_thema.bottomNav.menu.MenuFragment;
import com.example.hr_thema.detail.DetailFragment;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.infideap.drawerbehavior.AdvanceDrawerLayout;

public class NavigationDrawer extends AppCompatActivity implements IDrawerListener{
    BottomNavigationView bottomNavigationView;
    boolean doubleBackToExitPressedOnce = false;
    private AdvanceDrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        drawer = findViewById(R.id.drawer_layout);
        // TODO use this code to open drawer.
        //        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        //                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //        drawer.addDrawerListener(toggle);
        //        toggle.syncState();
        final NavigationView navigationView = findViewById(R.id.nav_view);
        drawer.setViewScale(Gravity.START, 0);
        drawer.setRadius(Gravity.START, 0);
        drawer.setViewElevation(Gravity.START, 30);

        loadFragment(new LastActivitiesFragment());
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setItemIconTintList(null);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();
                if (id == R.id.navigation_clock) {
                    menuItem.setIcon(R.drawable.checked);

                    bottomNavigationView.getMenu().getItem(0).setIcon(R.drawable.clock);
                    bottomNavigationView.getMenu().getItem(1).setIcon(R.drawable.checked_black);
                    bottomNavigationView.getMenu().getItem(2).setIcon(R.drawable.history_black);

                    badgeControl();
                    loadFragment(new LastActivitiesFragment());
                    return true;
                } else if (id == R.id.navigation_checked) {
                    //menuItem.setIcon(R.drawable.checked);

                    bottomNavigationView.getMenu().getItem(0).setIcon(R.drawable.clock_black);
                    bottomNavigationView.getMenu().getItem(1).setIcon(R.drawable.checked);
                    bottomNavigationView.getMenu().getItem(2).setIcon(R.drawable.history_black);

                    loadFragment(new MenuFragment());
                    return true;
                } else {
                    //menuItem.setIcon(R.drawable.checked);

                    bottomNavigationView.getMenu().getItem(0).setIcon(R.drawable.clock_black);
                    bottomNavigationView.getMenu().getItem(1).setIcon(R.drawable.checked_black);
                    bottomNavigationView.getMenu().getItem(2).setIcon(R.drawable.history1);

                    loadFragment(new DetailFragment());
                    return true;
                }
            }
        });
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        transaction.replace(R.id.nav_home, fragment);
        transaction.commit();
    }

    public void badgeControl() {
        // TODO: notification implementation test
        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.navigation_clock);
        badgeDrawable.setBackgroundColor(Color.rgb(157, 204, 82));
        badgeDrawable.setNumber(51);
    }

    @Override
    public void OpenDrawer() {
        drawer.openDrawer(GravityCompat.START);
    }
}
