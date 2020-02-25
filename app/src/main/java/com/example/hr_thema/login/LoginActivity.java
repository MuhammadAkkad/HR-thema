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
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hr_thema.R;
import com.example.hr_thema.api.APIService;
import com.example.hr_thema.api.APIUrl;
import com.example.hr_thema.api.BodyParameters;
import com.example.hr_thema.api.Token;
import com.example.hr_thema.api.User;
import com.example.hr_thema.navigationDrawer.NavigationDrawer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;


public class LoginActivity extends AppCompatActivity {
    Button btn_sign_in;
    Dialog myDialog;
    Context context;
    EditText txtEMail;
    EditText edtPassword;
    TextView textView;
    TextView forgetPassword;
    static String deneme;
    static Void denemeVoid;
    String accessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Token fakeToken = new Token();
        fakeToken.setAccessToken("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJib3JhbiIsImp0aSI6ImE2OTE4OTFlLTU0YmEtNGM1Yi1hNGZiLTRmODRhMDM0MmFiZSIsImlhdCI6MTU4MjUzMTU4NSwiVXNlckRhdGEiOiJ7XCJJZFwiOjgsXCJOYW1lXCI6XCJCb3JhblwiLFwiU3VybmFtZVwiOlwiR29rYnVsdXRcIixcIlVzZXJOYW1lXCI6XCJib3JhblwiLFwiRnVsbE5hbWVcIjpcIkJvcmFuIEdva2J1bHV0XCIsXCJQaG90b3VybFwiOlwiL0NvbnRlbnQvaW1hZ2VzL2VtcHktdXNlci5wbmdcIixcIkxvZ2luVHlwZXNcIjpudWxsLFwiUm9sZXNcIjpbe1wiQ29kZVwiOm51bGwsXCJDb2RlMlwiOm51bGwsXCJOYW1lXCI6bnVsbCxcIkRlc2NyaXB0aW9uXCI6bnVsbCxcIkRlc2NyaXB0aW9uMlwiOm51bGwsXCJSZWZLZXlcIjpudWxsLFwiUmVmS2V5MlwiOjAsXCJSZWZLZXkzXCI6bnVsbCxcIlJlZktleTRcIjowLFwiUmVmS2V5NVwiOlwiMDAwMDAwMDAtMDAwMC0wMDAwLTAwMDAtMDAwMDAwMDAwMDAwXCIsXCJSZWZLZXk2XCI6ZmFsc2UsXCJSZWZLZXlGbG9hdFwiOjAuMCxcIlJlZkRhdGVcIjpcIjAwMDEtMDEtMDFUMDA6MDA6MDBcIixcIlJlZkRhdGUyXCI6XCIwMDAxLTAxLTAxVDAwOjAwOjAwXCIsXCJSZWZEYXRlM1wiOm51bGwsXCJMaXN0XCI6bnVsbCxcIkludExpc3RcIjpbXSxcIlNlbGV0ZWRDb3VudFwiOm51bGwsXCJJc2NvbXBsZXRlZFwiOmZhbHNlLFwiU3RhdHVcIjpmYWxzZSxcIlJlZktleURvdWJsZVwiOjAuMCxcIlRpdGxlXCI6bnVsbCxcIkhhc1dhcm5pbmdNZXNzYWdlXCI6ZmFsc2UsXCJUYWdDb2xvckNvZGVcIjpudWxsLFwiSXNOb3JtXCI6ZmFsc2UsXCJDYW5Vc2VBc0xpbmtcIjpmYWxzZSxcIkxldmVsXCI6MCxcIlN1YkxldmVsXCI6MCxcIk5vcm1TdGFmZkRvbWFpblVzZXJJZFwiOjAsXCJQaG90b1wiOm51bGwsXCJPcmRlclwiOjAsXCJSZWZEYXRlRm9ybWF0XCI6XCIwMS4wMS4wMDAxXCIsXCJUZXh0XCI6bnVsbCxcIlBhcmFtZXRlckxpc3RcIjpbXSxcIkRvbWFpblVzZXJJZFwiOjAsXCJUYWdMaXN0XCI6bnVsbCxcIkludExpc3QyXCI6bnVsbCxcIkNvdW50XCI6MCxcIkN1cnJlbmN5RW51bVwiOjAsXCJJc0RlZmF1bHRcIjpmYWxzZSxcIkNvbG9yXCI6bnVsbCxcIkljb25cIjpudWxsLFwiSWRcIjoxLFwiSXNTZWxlY3RlZFwiOmZhbHNlLFwiSXNBY3RpdmVcIjpmYWxzZSxcIklzRGVsZXRlZFwiOmZhbHNlLFwiQ29tbWVudENvdW50XCI6MCxcIkFkZGVkQnlcIjowLFwiQWRkZWRCeUlkXCI6bnVsbCxcIkNyZWF0ZWREYXRlXCI6bnVsbH0se1wiQ29kZVwiOm51bGwsXCJDb2RlMlwiOm51bGwsXCJOYW1lXCI6bnVsbCxcIkRlc2NyaXB0aW9uXCI6bnVsbCxcIkRlc2NyaXB0aW9uMlwiOm51bGwsXCJSZWZLZXlcIjpudWxsLFwiUmVmS2V5MlwiOjAsXCJSZWZLZXkzXCI6bnVsbCxcIlJlZktleTRcIjowLFwiUmVmS2V5NVwiOlwiMDAwMDAwMDAtMDAwMC0wMDAwLTAwMDAtMDAwMDAwMDAwMDAwXCIsXCJSZWZLZXk2XCI6ZmFsc2UsXCJSZWZLZXlGbG9hdFwiOjAuMCxcIlJlZkRhdGVcIjpcIjAwMDEtMDEtMDFUMDA6MDA6MDBcIixcIlJlZkRhdGUyXCI6XCIwMDAxLTAxLTAxVDAwOjAwOjAwXCIsXCJSZWZEYXRlM1wiOm51bGwsXCJMaXN0XCI6bnVsbCxcIkludExpc3RcIjpbXSxcIlNlbGV0ZWRDb3VudFwiOm51bGwsXCJJc2NvbXBsZXRlZFwiOmZhbHNlLFwiU3RhdHVcIjpmYWxzZSxcIlJlZktleURvdWJsZVwiOjAuMCxcIlRpdGxlXCI6bnVsbCxcIkhhc1dhcm5pbmdNZXNzYWdlXCI6ZmFsc2UsXCJUYWdDb2xvckNvZGVcIjpudWxsLFwiSXNOb3JtXCI6ZmFsc2UsXCJDYW5Vc2VBc0xpbmtcIjpmYWxzZSxcIkxldmVsXCI6MCxcIlN1YkxldmVsXCI6MCxcIk5vcm1TdGFmZkRvbWFpblVzZXJJZFwiOjAsXCJQaG90b1wiOm51bGwsXCJPcmRlclwiOjAsXCJSZWZEYXRlRm9ybWF0XCI6XCIwMS4wMS4wMDAxXCIsXCJUZXh0XCI6bnVsbCxcIlBhcmFtZXRlckxpc3RcIjpbXSxcIkRvbWFpblVzZXJJZFwiOjAsXCJUYWdMaXN0XCI6bnVsbCxcIkludExpc3QyXCI6bnVsbCxcIkNvdW50XCI6MCxcIkN1cnJlbmN5RW51bVwiOjAsXCJJc0RlZmF1bHRcIjpmYWxzZSxcIkNvbG9yXCI6bnVsbCxcIkljb25cIjpudWxsLFwiSWRcIjozLFwiSXNTZWxlY3RlZFwiOmZhbHNlLFwiSXNBY3RpdmVcIjpmYWxzZSxcIklzRGVsZXRlZFwiOmZhbHNlLFwiQ29tbWVudENvdW50XCI6MCxcIkFkZGVkQnlcIjowLFwiQWRkZWRCeUlkXCI6bnVsbCxcIkNyZWF0ZWREYXRlXCI6bnVsbH1dLFwiUGhvbmVcIjpcIjUzNDM1MzUzXCIsXCJFbWFpbFwiOlwiOF9iZXloYW4udHV0dW5jdWxlckBiaWxnZWFkYW0uY29tXCIsXCJUaXRsZVwiOlwiRGlyZWt0w7ZyIFwifSIsIm5iZiI6MTU4MjUzMTU4NSwiZXhwIjoxNTgyNzA0Mzg1LCJpc3MiOiJIQ00uQXBpIiwiYXVkIjoiSENNLkFwaSJ9.Jfewv8bIdZj7x6jYoqOvVTrnCBWcb9klyKY1ow7_31U");

        btn_sign_in = findViewById(R.id.btn_sign_in_activity_login);
        context = this;
        myDialog = new Dialog(this);
        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gam();
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

    //API
    public void gam() {
        BodyParameters bodyParameters = new BodyParameters();
        bodyParameters.setUserName("boran");
        bodyParameters.setPassword("123");
        bodyParameters.setGrant_type("password");

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIUrl.BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient()).build();
        APIService apis = retrofit.create(APIService.class);
        Call<Token> call = apis.getDataToken("application/x-www-form-urlencoded",txtEMail.getText().toString(),edtPassword.getText().toString(),"password");

        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if(response.isSuccessful()){
                    Intent i = new Intent(getApplicationContext(),NavigationDrawer.class);
                    startActivity(i);
                    System.out.println("başarılı");
                    System.out.println(response.body().getAccessToken());
                    accessToken = response.body().getAccessToken();
                    System.out.println(response.body().getUserName());
                    System.out.println(response.body().getIssued());
                }
                else{
                    System.out.println("başarısız");
                    Toast.makeText(getApplicationContext(),"Girdiğiniz şifre veya kullanıcı adı hatalı!",Toast.LENGTH_LONG).show();
                }
                //deneme = response.body().getAccessToken();
                //Toast.makeText(getApplicationContext()," adsf" + response.body().getAccessToken(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                System.out.println(t + " adsf");
                Toast.makeText(getApplicationContext()," onFailure",Toast.LENGTH_LONG).show();
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
//                Token getToken = (Token) response.body();
//                getToken.getAccessToken();
                deneme = response.body().getFullName();
                if(response.isSuccessful() == true){
                    System.out.println("başarılı");
                    System.out.println(deneme + "Full Name");
                }
                else{
                    System.out.println("başarısız");
                }
                //deneme = response.body().getAccessToken();
                //Toast.makeText(getApplicationContext()," adsf" + response.body().getAccessToken(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println(t + " adsf");
                Toast.makeText(getApplicationContext()," onFailure" + t,Toast.LENGTH_LONG).show();
            }
        });
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
