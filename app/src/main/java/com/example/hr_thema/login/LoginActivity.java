package com.example.hr_thema.login;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
    Button btn_sign_in,btnOtherAccount;
    Dialog myDialog;
    Context context;
    CheckBox chbRemember;
    RoundedImageView rivProfilPhoto;
    TextView txtWelcome,txtFormDescription,txtEMail,txtPassword,txtOr;
    EditText edtEMail,edtPassword;

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

        txtWelcome = findViewById(R.id.txt_welcome_activity_login);
        txtFormDescription = findViewById(R.id.txt_welcome_description_activity_login);
        txtEMail = findViewById(R.id.txt_user_name_activity_login);
        txtPassword = findViewById(R.id.txt_password_activity_login2);
        txtOr = findViewById(R.id.txt_yada_activity_login);
        edtEMail = findViewById(R.id.tv_user_name_activity_login);
        edtPassword = findViewById(R.id.tv_password_activity_login);
        btnOtherAccount = findViewById(R.id.btn_another_account_sign_in_activity_login);
        rivProfilPhoto = findViewById(R.id.img_profile_activity_login);

        chbRemember = findViewById(R.id.cb_remember_me_activity_login);

        txtWelcome.setText("Hoşgeldin");
        rivProfilPhoto.setVisibility(View.GONE);
        txtEMail.setVisibility(View.VISIBLE);
        edtEMail.setVisibility(View.VISIBLE);
        txtPassword.setVisibility(View.VISIBLE);
        txtOr.setVisibility(View.GONE);
        btnOtherAccount.setVisibility(View.GONE);

        edtPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                txtPassword.setTextColor(ContextCompat.getColor(context, R.color.specialBlue));
                txtEMail.setTextColor(ContextCompat.getColor(context, R.color.specialGray));
            }
        });

       edtEMail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
           @Override
           public void onFocusChange(View v, boolean hasFocus) {
               txtPassword.setTextColor(ContextCompat.getColor(context, R.color.specialGray));
               txtEMail.setTextColor(ContextCompat.getColor(context, R.color.specialBlue));
           }
       });


        chbRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    txtPassword.setTextColor(ContextCompat.getColor(context, R.color.specialBlue));
                    txtWelcome.setText("Hoşgeldin,Emre");
                    txtEMail.setVisibility(View.GONE);
                    edtEMail.setVisibility(View.GONE);
                    rivProfilPhoto.setVisibility(View.VISIBLE);
                    txtOr.setVisibility(View.VISIBLE);
                    btnOtherAccount.setVisibility(View.VISIBLE);
                    txtPassword.setVisibility(View.VISIBLE);
                }
                else{
                    txtPassword.setTextColor(ContextCompat.getColor(context, R.color.specialGray));
                    txtWelcome.setText("Hoşgeldin");
                    rivProfilPhoto.setVisibility(View.GONE);
                    txtEMail.setVisibility(View.VISIBLE);
                    edtEMail.setVisibility(View.VISIBLE);
                    txtPassword.setVisibility(View.VISIBLE);
                    txtOr.setVisibility(View.GONE);
                    btnOtherAccount.setVisibility(View.GONE);
                }
            }
        });
    }
    void home() {
        Intent home = new Intent(this, NavigationDrawer.class);
        startActivity(home);
    }
}
