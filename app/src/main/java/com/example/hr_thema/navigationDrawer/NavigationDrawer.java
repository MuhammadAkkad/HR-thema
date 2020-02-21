package com.example.hr_thema.navigationDrawer;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
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

public class NavigationDrawer extends AppCompatActivity implements IDrawerListener {
    BottomNavigationView bottomNavigationView;
    boolean doubleBackToExitPressedOnce = false;
    private AdvanceDrawerLayout drawer;
    NavigationView navigationView;
    MenuItem menuItemAnasayfa,onaylanmayiBekleyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

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
        bottomNavigationView.getMenu().getItem(0).setIcon(R.drawable.clock);
        bottomNavigationView.getMenu().getItem(1).setIcon(R.drawable.checked_black);
        bottomNavigationView.getMenu().getItem(2).setIcon(R.drawable.history_black);

        onaylanmayiBekleyen = findViewById(R.id.onaylanmayı_bekleyen);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                navigationView.setItemIconTintList(null);
                if (item.getItemId() == R.id.anasayfa){
                    item.setIcon(R.drawable.group38_black);
                    navigationView.getMenu().getItem(1).setIcon(R.drawable.group25);
                    navigationView.getMenu().getItem(2).setIcon(R.drawable.group27);
                    navigationView.getMenu().getItem(3).setIcon(R.drawable.group28);
                    navigationView.getMenu().getItem(4).setIcon(R.drawable.group29);
                    navigationView.getMenu().getItem(5).setIcon(R.drawable.group30);
                    navigationView.getMenu().getItem(6).setIcon(R.drawable.group31);
                    navigationView.getMenu().getItem(7).setIcon(R.drawable.group40);
                    navigationView.getMenu().getItem(8).setIcon(R.drawable.group41);
                    drawer.closeDrawer(GravityCompat.START);
                }
                if (item.getItemId() == R.id.onaylanmayı_bekleyen){
                    item.setIcon(R.drawable.group25_black);
                    navigationView.getMenu().getItem(0).setIcon(R.drawable.group38);
                    navigationView.getMenu().getItem(2).setIcon(R.drawable.group27);
                    navigationView.getMenu().getItem(3).setIcon(R.drawable.group28);
                    navigationView.getMenu().getItem(4).setIcon(R.drawable.group29);
                    navigationView.getMenu().getItem(5).setIcon(R.drawable.group30);
                    navigationView.getMenu().getItem(6).setIcon(R.drawable.group31);
                    navigationView.getMenu().getItem(7).setIcon(R.drawable.group40);
                    navigationView.getMenu().getItem(8).setIcon(R.drawable.group41);
                    drawer.closeDrawer(GravityCompat.START);
                }
                if (item.getItemId() == R.id.Gelen_kutusu){
                    item.setIcon(R.drawable.group27_black);
                    navigationView.getMenu().getItem(0).setIcon(R.drawable.group38);
                    navigationView.getMenu().getItem(1).setIcon(R.drawable.group25);
                    navigationView.getMenu().getItem(3).setIcon(R.drawable.group28);
                    navigationView.getMenu().getItem(4).setIcon(R.drawable.group29);
                    navigationView.getMenu().getItem(5).setIcon(R.drawable.group30);
                    navigationView.getMenu().getItem(6).setIcon(R.drawable.group31);
                    navigationView.getMenu().getItem(7).setIcon(R.drawable.group40);
                    navigationView.getMenu().getItem(8).setIcon(R.drawable.group41);
                    drawer.closeDrawer(GravityCompat.START);
                }
                if (item.getItemId() == R.id.Kişiler){
                    item.setIcon(R.drawable.group28_black);
                    navigationView.getMenu().getItem(0).setIcon(R.drawable.group38);
                    navigationView.getMenu().getItem(1).setIcon(R.drawable.group25);
                    navigationView.getMenu().getItem(2).setIcon(R.drawable.group27);
                    navigationView.getMenu().getItem(4).setIcon(R.drawable.group29);
                    navigationView.getMenu().getItem(5).setIcon(R.drawable.group30);
                    navigationView.getMenu().getItem(6).setIcon(R.drawable.group31);
                    navigationView.getMenu().getItem(7).setIcon(R.drawable.group40);
                    navigationView.getMenu().getItem(8).setIcon(R.drawable.group41);
                    drawer.closeDrawer(GravityCompat.START);
                }
                if (item.getItemId() == R.id.Çalışma_Alanı_Yönetimi){
                    item.setIcon(R.drawable.group29_black);
                    navigationView.getMenu().getItem(0).setIcon(R.drawable.group38);
                    navigationView.getMenu().getItem(1).setIcon(R.drawable.group25);
                    navigationView.getMenu().getItem(2).setIcon(R.drawable.group27);
                    navigationView.getMenu().getItem(3).setIcon(R.drawable.group28);
                    navigationView.getMenu().getItem(5).setIcon(R.drawable.group30);
                    navigationView.getMenu().getItem(6).setIcon(R.drawable.group31);
                    navigationView.getMenu().getItem(7).setIcon(R.drawable.group40);
                    navigationView.getMenu().getItem(8).setIcon(R.drawable.group41);
                    drawer.closeDrawer(GravityCompat.START);
                }
                if (item.getItemId() == R.id.Yönetim){
                    item.setIcon(R.drawable.group30_black);
                    navigationView.getMenu().getItem(0).setIcon(R.drawable.group38);
                    navigationView.getMenu().getItem(1).setIcon(R.drawable.group25);
                    navigationView.getMenu().getItem(2).setIcon(R.drawable.group27);
                    navigationView.getMenu().getItem(3).setIcon(R.drawable.group38);
                    navigationView.getMenu().getItem(4).setIcon(R.drawable.group29);
                    navigationView.getMenu().getItem(6).setIcon(R.drawable.group31);
                    navigationView.getMenu().getItem(7).setIcon(R.drawable.group40);
                    navigationView.getMenu().getItem(8).setIcon(R.drawable.group41);
                    drawer.closeDrawer(GravityCompat.START);
                }
                if (item.getItemId() == R.id.Organizasyon_Şeması){
                    item.setIcon(R.drawable.group31_black);
                    navigationView.getMenu().getItem(0).setIcon(R.drawable.group38);
                    navigationView.getMenu().getItem(1).setIcon(R.drawable.group25);
                    navigationView.getMenu().getItem(2).setIcon(R.drawable.group27);
                    navigationView.getMenu().getItem(3).setIcon(R.drawable.group38);
                    navigationView.getMenu().getItem(4).setIcon(R.drawable.group29);
                    navigationView.getMenu().getItem(5).setIcon(R.drawable.group30);
                    navigationView.getMenu().getItem(7).setIcon(R.drawable.group40);
                    navigationView.getMenu().getItem(8).setIcon(R.drawable.group41);
                    drawer.closeDrawer(GravityCompat.START);
                }
                if (item.getItemId() == R.id.Ayarlar){
                    item.setIcon(R.drawable.group40_black);
                    navigationView.getMenu().getItem(0).setIcon(R.drawable.group38);
                    navigationView.getMenu().getItem(1).setIcon(R.drawable.group25);
                    navigationView.getMenu().getItem(2).setIcon(R.drawable.group27);
                    navigationView.getMenu().getItem(3).setIcon(R.drawable.group28);
                    navigationView.getMenu().getItem(4).setIcon(R.drawable.group29);
                    navigationView.getMenu().getItem(5).setIcon(R.drawable.group30);
                    navigationView.getMenu().getItem(6).setIcon(R.drawable.group31);
                    navigationView.getMenu().getItem(8).setIcon(R.drawable.group41);
                    drawer.closeDrawer(GravityCompat.START);
                }
                if (item.getItemId() == R.id.cikisyap){
                    item.setIcon(R.drawable.group41_black);
                    navigationView.getMenu().getItem(0).setIcon(R.drawable.group38);
                    navigationView.getMenu().getItem(1).setIcon(R.drawable.group25);
                    navigationView.getMenu().getItem(2).setIcon(R.drawable.group27);
                    navigationView.getMenu().getItem(3).setIcon(R.drawable.group38);
                    navigationView.getMenu().getItem(4).setIcon(R.drawable.group29);
                    navigationView.getMenu().getItem(5).setIcon(R.drawable.group30);
                    navigationView.getMenu().getItem(6).setIcon(R.drawable.group31);
                    navigationView.getMenu().getItem(7).setIcon(R.drawable.group40);
                    drawer.closeDrawer(GravityCompat.START);
                }
                return false;
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();
                if (id == R.id.navigation_clock) {
                    bottomNavigationView.getMenu().getItem(0).setIcon(R.drawable.clock);
                    bottomNavigationView.getMenu().getItem(1).setIcon(R.drawable.checked_black);
                    bottomNavigationView.getMenu().getItem(2).setIcon(R.drawable.history_black);

                    badgeControl();
                    loadFragment(new LastActivitiesFragment());
                    return true;
                } else if (id == R.id.navigation_checked) {
                    bottomNavigationView.getMenu().getItem(0).setIcon(R.drawable.clock_black);
                    bottomNavigationView.getMenu().getItem(1).setIcon(R.drawable.checked);
                    bottomNavigationView.getMenu().getItem(2).setIcon(R.drawable.history_black);

                    loadFragment(new MenuFragment());
                    return true;
                } else {
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

// TODO : on back pressed exit app
//    @Override
//    public void onBackPressed() {
//        // if back pressed twice exit app
//        if (doubleBackToExitPressedOnce) {
//            super.onBackPressed();
//            finishAffinity();
//            return;
//        }
//
//        this.doubleBackToExitPressedOnce = true;
//        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
//
//        new Handler().postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                doubleBackToExitPressedOnce = false;
//            }
//        }, 2000);
//    }



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