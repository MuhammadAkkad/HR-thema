package com.example.hr_thema.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hr_thema.R;
import com.example.hr_thema.home.HomeActivity;

public class LoginActivity extends AppCompatActivity {
    Button btn_sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_sign_in = findViewById(R.id.btn_sign_in_activity_login);
        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home();
            }
        });
    }
    void home (){
        Intent home = new Intent(this , HomeActivity.class);
        startActivity(home);
    }
}
