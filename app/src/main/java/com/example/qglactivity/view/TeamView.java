package com.example.qglactivity.view;

import com.example.qglactivity.bean.BusinessMessageBean;
import com.example.qglactivity.bean.TeamBean;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2021/11/3
 * 描述:我的伙伴
 */
public interface TeamView extends IBaseView{
    //显示数据
    void showListData(TeamBean bean);
    //token错误
    void showErrorToken(String msg);
    //无更多数据
    void loadMoreEnd();
    //有更多数据
    void loadMoreComplete();
}