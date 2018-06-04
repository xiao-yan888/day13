package com.example.administrator.day13.reg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.day13.R;
import com.example.administrator.day13.base.BaseActivity;
import com.example.administrator.day13.component.DaggerHttpComponent;
import com.example.administrator.day13.module.HttpModule;

public class Main2Activity extends BaseActivity<RegPresenter> implements View.OnClickListener,RegContract.View {

    private EditText mEtMobile;
    private EditText mEtPass;
    /**
     * 确定注册
     */
    private Button mQureg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        mEtMobile = (EditText) findViewById(R.id.et_mobile);
        mEtPass = (EditText) findViewById(R.id.et_pass);
        mQureg = (Button) findViewById(R.id.qureg);
        mQureg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.qureg:
                String mobile = mEtMobile.getText().toString();
                String password = mEtPass.getText().toString();
                mPresenter.reg(mobile, password);


                break;
        }
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_main2;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModule(new HttpModule())
                .build()
                .inject(this);
    }

    @Override
    public void regSuccess() {
        finish();
    }
}
