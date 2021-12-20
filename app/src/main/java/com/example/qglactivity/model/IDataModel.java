package com.example.qglactivity.model;

import com.example.qglactivity.bean.DataPageBean;
import com.example.qglactivity.bean.HomeAdvBean;
import com.example.qglactivity.bean.HomePageBean;

/**
 * 作者: qgl
 * 创建日期：2021/10/30
 * 描述:首页
 */
public interface IDataModel {
    void isDate(OnLoadListener loadListener);


    interface OnLoadListener {
        void showData(DataPageBean bean);

        void showError(String msg);

        void showErrorToken(String msg);

        void NoRealName();

    }

}