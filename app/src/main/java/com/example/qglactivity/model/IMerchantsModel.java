package com.example.qglactivity.model;

import com.example.qglactivity.bean.MerchantsBean;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2021/11/3
 * 描述:
 */
public interface IMerchantsModel {

    void isMerchantsData(String userId,int mCount,int pageSize, String nikeName, String turnover,OnLoadListener loadListener);


    interface OnLoadListener {
        void showData(MerchantsBean bean);

        void showError(String msg);

        void showErrorToken(String msg);
    }
} 