package com.example.qglactivity.model;

import com.example.qglactivity.bean.DataPageBean;
import com.example.qglactivity.bean.MinePageBean;

/**
 * 作者: qgl
 * 创建日期：2021/10/30
 * 描述:我的
 */
public interface IMineModel {
    void isMine(String userId,OnLoadListener loadListener);


    interface OnLoadListener {
        void showData(MinePageBean bean);

        void showError(String msg);

        void showErrorToken(String msg);

        void NoRealName();

    }

}