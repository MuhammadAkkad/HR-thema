package com.example.hr_thema.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
    @Headers("Content-Type:application/x-www-form-urlencoded")
//    @FormUrlEncoded
    @POST("oauth/token")
    Call<Token> getToken(@Body String userName, @Body String password, @Body String grant_type);
}
