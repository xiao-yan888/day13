package com.example.administrator.day13.login;

import com.example.administrator.day13.base.BaseContract;
import com.example.administrator.day13.bean.UserBean;

public interface LoginContract {
    interface view extends BaseContract.BaseView{
        void loginSuccess(UserBean userBean);
    }
    interface presenter extends BaseContract.BasePresenter<view> {
        void login(String mobile, String password);

    }
}