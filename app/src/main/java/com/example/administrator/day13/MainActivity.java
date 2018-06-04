package com.example.administrator.day13;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.day13.base.BaseActivity;
import com.example.administrator.day13.bean.UserBean;
import com.example.administrator.day13.component.DaggerHttpComponent;
import com.example.administrator.day13.login.LoginContract;
import com.example.administrator.day13.login.LoginPresenter;
import com.example.administrator.day13.module.HttpModule;
import com.example.administrator.day13.reg.Main2Activity;
import com.example.administrator.day13.utils.SharedPreferencesUtils;

public class MainActivity extends BaseActivity<LoginPresenter> implements LoginContract.view,View.OnClickListener {

    private EditText mEtMobile;
    private EditText mEtPass;
    /**
     * 登录
     */
    private Button mLogin;
    /**
     * 注册
     */
    private Button mReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        mEtMobile = (EditText) findViewById(R.id.et_mobile);
        mEtPass = (EditText) findViewById(R.id.et_pass);
        mLogin = (Button) findViewById(R.id.login);
        mLogin.setOnClickListener(this);
        mReg = (Button) findViewById(R.id.reg);
        mReg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.login:
                String mobile = mEtMobile.getText().toString();
                String pass = mEtPass.getText().toString();
                mPresenter.login(mobile,pass);
                break;
            case R.id.reg:

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);

                break;
        }
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    public void loginSuccess(UserBean userBean) {
        UserBean.DataBean data = userBean.getData();
        String mobile = data.getMobile();
        SharedPreferencesUtils.setParam(this, "uid", userBean.getData().getUid() + "");
        SharedPreferencesUtils.setParam(this, "name", userBean.getData().getUsername() + "");
        SharedPreferencesUtils.setParam(this, "iconUrl", userBean.getData().getIcon() + "");
        SharedPreferencesUtils.setParam(this, "token", userBean.getData().getToken() + "");
        Intent intent = new Intent(MainActivity.this,Main3Activity.class);
        startActivity(intent);
    }
}
