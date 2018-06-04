package com.example.administrator.day13.net;

import com.example.administrator.day13.bean.RegisterBean;
import com.example.administrator.day13.bean.UserBean;

import io.reactivex.Observable;

public class LoginApi {
    private static LoginApi loginApi;
    private LoginApiService loginApiService;
    private LoginApi(LoginApiService loginApiService) {
        this.loginApiService=loginApiService;
    }

    public static LoginApi getLoginApi(LoginApiService loginApiService){
        if (loginApi==null){
           loginApi=new LoginApi(loginApiService);
        }
        return loginApi;
    }

    public Observable<UserBean> login(String mobile, String password){
       return loginApiService.login(mobile,password);
    }

    public Observable<RegisterBean> reg(String mobile, String password) {
        return loginApiService.reg(mobile, password);
    }

}