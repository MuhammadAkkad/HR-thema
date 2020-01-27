package com.example.hr_thema.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.hr_thema.R;
import com.example.hr_thema.home.HomeActivity;
import com.example.hr_thema.navigationDrawer.NavigationDrawer;

public class LoginActivity extends AppCompatActivity {
    Button btn_sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setLightStatusBar(this.findViewById(R.id.login_activity_layout).getRootView(), this);
        btn_sign_in = findViewById(R.id.btn_sign_in_activity_login);
        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home();
            }
        });


    }
    void home (){
        Intent home = new Intent(this , NavigationDrawer.class);
        startActivity(home);
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
