package com.example.qglactivity.view;

import com.example.qglactivity.bean.BusinessMessageBean;
import com.example.qglactivity.bean.DataPageBean;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2021/11/3
 * 描述:业务消息
 */
public interface BusinessMessageView extends IBaseView{
    //显示数据
    void showListData(List<BusinessMessageBean> bean);
    //token错误
    void showErrorToken(String msg);
    //无更多数据
    void loadMoreEnd();
    //有更多数据
    void loadMoreComplete();
}