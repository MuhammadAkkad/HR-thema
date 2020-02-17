package com.example.hr_thema.login;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.hr_thema.R;
import com.example.hr_thema.navigationDrawer.NavigationDrawer;
import com.makeramen.roundedimageview.RoundedImageView;


public class LoginActivity extends AppCompatActivity {
    Button btn_sign_in;
    Dialog myDialog;
    Context context;
    EditText txtEMail;
    EditText edtPassword;
    TextView textView;
    TextView forgetPassword;


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

        forgetPassword = findViewById(R.id.txt_forgot_password_activity_login);
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoggedInUser();
            }
        });

        txtEMail = findViewById(R.id.tv_email_activity_login);
        edtPassword = findViewById(R.id.tv_password_activity_login);


        textView = findViewById(R.id.textView5);

        TextPaint paint = textView.getPaint();
        float width = paint.measureText("Giriş Yap");

        Shader textShader = new LinearGradient(0, 0, width, textView.getTextSize(),
                new int[]{
                        Color.parseColor("#CF8FDC"),
                        Color.parseColor("#D691C1"),
                        Color.parseColor("#E1939E"),
                        Color.parseColor("#ED9576"),
                        Color.parseColor("#F39663"),
                }, null, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);

    }
    void home() {
        Intent home = new Intent(this, NavigationDrawer.class);
        startActivity(home);
    }

    void LoggedInUser(){
        Intent i = new Intent(this, LoggedInActivity.class);
        startActivity(i);
    }
}
