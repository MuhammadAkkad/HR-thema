package com.example.hr_thema.home;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hr_thema.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Toast.makeText(HomeActivity.this, "navigation_home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_menu:
                        Toast.makeText(HomeActivity.this, "navigation_menu", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_notifications:
                        Toast.makeText(HomeActivity.this, "navigation_notifications", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_settings:
                        Toast.makeText(HomeActivity.this, "navigation_settings", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

    }
}
