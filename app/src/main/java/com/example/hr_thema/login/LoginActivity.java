package com.example.hr_thema.login;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hr_thema.R;
import com.example.hr_thema.navigationDrawer.NavigationDrawer;


public class LoginActivity extends AppCompatActivity {
    Button btn_sign_in;
    Dialog myDialog;
    Context context;
    CheckBox chbRemember;

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

        chbRemember = findViewById(R.id.cb_remember_me_activity_login);

        chbRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"UNChecked",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void home() {
        Intent home = new Intent(this, NavigationDrawer.class);
        startActivity(home);
    }
}
