package com.example.qglactivity.model;

import com.example.qglactivity.bean.BusinessMessageBean;
import com.example.qglactivity.bean.DataPageBean;
import com.example.qglactivity.bean.LoginBean;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2021/11/3
 * 描述:
 */
public interface IBusinessMessageModel {

    void isMessageData(String userId,int mCount,int pageSize, OnLoadListener loadListener);


    interface OnLoadListener {
        void showData(List<BusinessMessageBean> bean);

        void showError(String msg);

        void showErrorToken(String msg);
    }
} 