package com.example.hr_thema.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.hr_thema.R;

import com.example.hr_thema.navigationDrawer.NavigationDrawer;


public class LoginActivity extends AppCompatActivity {
    Button btn_sign_in;
    Dialog myDialog;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setLightStatusBar(this.findViewById(R.id.login_activity_layout).getRootView(), this);
        btn_sign_in = findViewById(R.id.btn_sign_in_activity_login);
        context = this;
        myDialog = new Dialog(this);
        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             //  Intent i = new Intent(LoginActivity.this, PopupExample.class);
             //  startActivity(i);
                //showPopup2(v);
                 home();

               // dialogShow();
            }
        });

    }

    public void dialogShow(){
        myDialog.setContentView(R.layout.activity_filter);

      // Window window = myDialog.getWindow();
      // WindowManager.LayoutParams wlp = window.getAttributes();

      // wlp.gravity = Gravity.CENTER;
      // window.setAttributes(wlp);

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
        myDialog.show();
    }

    public void showPopup2(View v){
        Button btnClose ;
        myDialog.setContentView(R.layout.activity_popup_example);
        btnClose = myDialog.findViewById(R.id.ibNegative);

          btnClose.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  myDialog.dismiss();
              }
          });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
        myDialog.show();
    }

    void home (){
        Intent home = new Intent(this , NavigationDrawer.class);
        startActivity(home);
    }
    // set status bar icon colors to dark
    public static void setLightStatusBar(View view, Activity activity) {
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
    }



}
