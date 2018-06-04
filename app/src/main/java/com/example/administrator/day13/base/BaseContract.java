package com.example.administrator.day13.base;

/**
 * Created by Administrator on 2018/5/23 0023.
 */

public interface BaseContract {
    //抽取所有presenter的共性，例如绑定、解绑
    interface BasePresenter<T extends BaseView>{
        void attchView(T view);
        void detachView();
    }
    //抽取所有view共性、例如显示进度条和关闭进度
    interface BaseView{
        void showLoading();
        void dismissLoading();
    }
}
