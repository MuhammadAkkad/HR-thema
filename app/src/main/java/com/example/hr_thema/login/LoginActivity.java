package com.example.hr_thema.login;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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


        btn_sign_in = findViewById(R.id.btn_sign_in_activity_login);
        context = this;
        myDialog = new Dialog(this);
        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home();
            }
        });

    }
    void home() {
        Intent home = new Intent(this, NavigationDrawer.class);
        startActivity(home);
    }
}
