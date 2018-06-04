package com.example.administrator.day13.login;

import android.util.Log;

import com.example.administrator.day13.base.BasePresenter;
import com.example.administrator.day13.bean.UserBean;
import com.example.administrator.day13.net.LoginApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter<LoginContract.view> implements LoginContract.presenter {
  private LoginApi loginApi;
   @Inject
    public LoginPresenter(LoginApi loginApi) {
       this.loginApi=loginApi;
    }

    @Override
    public void login(String mobile, String password) {
        loginApi.login(mobile,password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {
                    mView.loginSuccess(userBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                       // Toast.makeText(LoginPresenter.this,"", Toast.LENGTH_SHORT).show();
                        Log.e("zzz","错误");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}