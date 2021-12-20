package com.example.qglactivity.model;

import com.example.qglactivity.bean.BusinessMessageBean;
import com.example.qglactivity.bean.TeamBean;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2021/11/3
 * 描述:我的伙伴
 */
public interface ITeamModel {

    void isTeamData(String userId,int mCount,int pageSize,String nickName,String sortTime, OnLoadListener loadListener);

    interface OnLoadListener {
        void showData(TeamBean bean);

        void showError(String msg);

        void showErrorToken(String msg);
    }
} 