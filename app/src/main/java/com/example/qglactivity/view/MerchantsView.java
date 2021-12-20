package com.example.qglactivity.view;

import com.example.qglactivity.bean.BusinessMessageBean;
import com.example.qglactivity.bean.MerchantsBean;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2021/11/3
 * 描述:我的商户
 */
public interface MerchantsView extends IBaseView{
    //显示数据
    void showListData(MerchantsBean bean);
    //token错误
    void showErrorToken(String msg);
    //无更多数据
    void loadMoreEnd();
    //有更多数据
    void loadMoreComplete();
}