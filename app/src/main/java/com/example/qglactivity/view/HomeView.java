package com.example.qglactivity.view;

import com.example.qglactivity.bean.HomeAdvBean;
import com.example.qglactivity.bean.HomePageBean;

/**
 * 作者: qgl
 * 创建日期：2021/11/1
 * 描述:首页
 */
public interface HomeView extends IBaseView {

    //显示数据
    void showHomeData(HomePageBean bean);

    //token错误
    void showErrorToken(String msg);

    //未实名
    void NoRealName();

    void BannerSuccess(HomeAdvBean advBean);

    void BannerFail(String message);


} 