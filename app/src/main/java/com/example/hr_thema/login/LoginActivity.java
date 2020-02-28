package com.example.hr_thema.login;

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
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hr_thema.R;
import com.example.hr_thema.api.APIService;
import com.example.hr_thema.api.APIUrl;
import com.example.hr_thema.api.Deneme;
import com.example.hr_thema.api.Token;
import com.example.hr_thema.api.User;
import com.example.hr_thema.navigationDrawer.NavigationDrawer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity {
    Button btn_sign_in;
    Dialog myDialog;
    Context context;
    EditText edtEMail;
    EditText edtPassword;
    TextView textView;
    TextView forgetPassword;
    static String deneme;
    String accessToken;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progressBarLogin);
        edtEMail = findViewById(R.id.tv_email_activity_login);
        edtPassword = findViewById(R.id.tv_password_activity_login);
        textView = findViewById(R.id.textView5);
        btn_sign_in = findViewById(R.id.btn_sign_in_activity_login);
        context = this;
        myDialog = new Dialog(this);

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                loginControlWebAPI();
            }
        });

        forgetPassword = findViewById(R.id.txt_forgot_password_activity_login);
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoggedInUser();
            }
        });


        TextPaint paint = textView.getPaint();
        float width = paint.measureText("Giriş Yap");

        progressBar.setVisibility(View.GONE);

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

    //API
    public void loginControlWebAPI() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIUrl.BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient()).build();
        APIService apis = retrofit.create(APIService.class);
        Call<Token> call = apis.getDataToken("application/x-www-form-urlencoded",edtEMail.getText().toString(),edtPassword.getText().toString(),"password");

        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if(response.isSuccessful()){
                    accessToken = response.body().getAccessToken();
                    Deneme.getTokenNow = accessToken;
                    Intent i = new Intent(getApplicationContext(),NavigationDrawer.class);
                    startActivity(i);
                    System.out.println("Başarılı");
                }
                else{
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(),"Girdiğiniz şifre veya kullanıcı adı hatalı!",Toast.LENGTH_LONG).show();
                    System.out.println("Başarısız");
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t + " onFailure",Toast.LENGTH_LONG).show();
                System.out.println(t + "onFailure");
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void getUserInformation(){
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIUrl.BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient()).build();
        APIService apis = retrofit.create(APIService.class);
        Call<User> call = apis.getUserInformation("application/x-www-form-urlencoded","Bearer " + accessToken);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                deneme = response.body().getFullName();
                if(response.isSuccessful() == true){
                    System.out.println("başarılı");
                    System.out.println(deneme + "Full Name");
                }
                else{
                    System.out.println("başarısız");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println(t + " adsf");
                Toast.makeText(getApplicationContext()," onFailure" + t,Toast.LENGTH_LONG).show();
            }
        });
    }

    void LoggedInUser(){
        Intent i = new Intent(this, LoggedInActivity.class);
        startActivity(i);
    }
}
