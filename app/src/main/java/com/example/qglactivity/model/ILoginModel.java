package com.example.qglactivity.model;

import com.example.qglactivity.bean.LoginBean;

/**
 * 作者: qgl
 * 创建日期：2021/10/30
 * 描述:
 */
public interface ILoginModel {

    public void iLogin(String userName,String passWord, OnLoadListener loadListener);


    interface OnLoadListener {
        void showData(LoginBean bean);

        void showError(String msg);

    }

} 