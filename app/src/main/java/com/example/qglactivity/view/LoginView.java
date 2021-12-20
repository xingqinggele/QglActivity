package com.example.qglactivity.view;

import com.example.qglactivity.bean.LoginBean;

/**
 * 作者: qgl
 * 创建日期：2021/10/30
 * 描述:登录
 */
public interface LoginView extends IBaseView {
    //显示数据
    void showGoodList(LoginBean bean);

}