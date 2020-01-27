package com.example.hr_thema.home;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.hr_thema.R;
import com.example.hr_thema.menu.MenuFragment;
import com.example.hr_thema.notification.NotificationFragment;
import com.example.hr_thema.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView navigation;
//    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        loadFragment(new HomeFragment());
        setLightStatusBar(this.findViewById(R.id.home_activity_layout).getRootView(), this);
        navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.anasayfa) {
                    //toolbar.setTitle(getResources().getString(R.string.title_home));
                    loadFragment(new HomeFragment());
                    return true;
                } else if (id == R.id.onaylanmayı_bekleyen) {
                    //toolbar.setTitle(getResources().getString(R.string.title_category));
                    loadFragment(new MenuFragment());
                    return true;
                } else if (id == R.id.Gelen_kutusu) {
                    //toolbar.setTitle(getResources().getString(R.string.title_notifications));
                    loadFragment(new NotificationFragment());
                    return true;
                } else if (id == R.id.Kişiler) {
                    //toolbar.setTitle(getResources().getString(R.string.title_profile));
                    loadFragment(new SettingsFragment());
                    return true;
                }
                else if (id == R.id.Çalışma_Alanı_Yönetimi) {
                    //toolbar.setTitle(getResources().getString(R.string.title_profile));
                    loadFragment(new SettingsFragment());
                    return true;
                }else if (id == R.id.Yönetim) {
                    //toolbar.setTitle(getResources().getString(R.string.title_profile));
                    loadFragment(new SettingsFragment());
                    return true;
                }else if (id == R.id.Organizasyon_Şeması) {
                    //toolbar.setTitle(getResources().getString(R.string.title_profile));
                    loadFragment(new SettingsFragment());
                    return true;
                }
                return true;
            }
        });

    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //transaction.replace(R.id.fragments_display_frame, fragment);
        //transaction.commit();
    }
    // set status bar icon colors to dark
    public static void setLightStatusBar(View view, Activity activity) {
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//
//            int flags = view.getSystemUiVisibility();
//            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
//
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        //}
    }

}
