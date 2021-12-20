package com.example.qglactivity.model;

import com.example.qglactivity.bean.HomeAdvBean;
import com.example.qglactivity.bean.HomePageBean;

/**
 * 作者: qgl
 * 创建日期：2021/10/30
 * 描述:首页
 */
public interface IHomeModel {
    //首页数据
    void iHome(String userId, OnLoadListener loadListener);
    //首页数据
    interface OnLoadListener {
        void showData(HomePageBean bean);

        void showError(String msg);

        void showErrorToken(String msg);
        //未进行实名
        void NoRealName();

    }


    void Banner(BeannerView loadListener);
    //请求banner轮播图的Model
    interface BeannerView {
        void LoadSuccess(HomeAdvBean advBean);
        void LoadFail(String message);

    }

}