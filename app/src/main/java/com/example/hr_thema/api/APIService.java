package com.example.hr_thema.api;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    //@Headers("Content-Type:application/x-www-form-urlencoded")
    //@Headers({ "Content-Type: application/json;charset=UTF-8"})
    @POST("oauth/token")
    @FormUrlEncoded
    Call<Token> getDataToken(@Header("Content-Type") String content_type, @Field("userName") String userName, @Field("password") String password, @Field("grant_type") String grant_type);

    @POST("WorkflowApi/GetLoginInfo")
    Call<User> getUserInformation(@Header("Content-Type") String content_type,@Header("Authorization") String Authorization);

//    Call<Token> getToken(String userName, String password,String grant_type);
}
