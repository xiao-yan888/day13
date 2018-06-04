package com.example.administrator.day13.net;

import com.example.administrator.day13.bean.RegisterBean;
import com.example.administrator.day13.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginApiService {
    @FormUrlEncoded
    @POST("user/login")
    Observable<UserBean> login(@Field("mobile") String mobile,
                               @Field("password") String password);

    @FormUrlEncoded
    @POST("user/reg")
    Observable<RegisterBean> reg(@Field("mobile") String mobile,
                                 @Field("password") String password);

}