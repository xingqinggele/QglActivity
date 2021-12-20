package com.example.qglactivity.view;

import com.example.qglactivity.bean.DataPageBean;

/**
 * 作者: qgl
 * 创建日期：2021/11/2
 * 描述:数据页
 */
public interface DataView extends IBaseView{

    //显示数据
    void showHomeData(DataPageBean bean);

    //token错误
    void showErrorToken(String msg);

    //未实名
    void NoRealName();

} 