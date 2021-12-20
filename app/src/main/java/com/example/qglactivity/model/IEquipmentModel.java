package com.example.qglactivity.model;

import com.example.qglactivity.bean.EquipmentBean;
import com.example.qglactivity.bean.HomeAdvBean;
import com.example.qglactivity.bean.HomePageBean;

/**
 * 作者: qgl
 * 创建日期：2021/10/30
 * 描述:终端管理
 */
public interface IEquipmentModel {

    //首页数据
    void isEquipmentData(String userId, OnLoadListener loadListener);


    //首页数据
    interface OnLoadListener {

        void showData(EquipmentBean bean);

        void showError(String msg);

        void showErrorToken(String msg);

    }

}