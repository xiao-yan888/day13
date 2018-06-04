package com.example.administrator.day13.reg;

import com.example.administrator.day13.base.BaseContract;

public interface RegContract {
    interface View extends BaseContract.BaseView {
        void regSuccess();
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void reg(String mobile, String password);
    }
}
