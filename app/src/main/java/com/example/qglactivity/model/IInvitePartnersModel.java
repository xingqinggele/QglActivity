package com.example.qglactivity.model;

import com.example.qglactivity.bean.InvitePartnersBean;
import com.example.qglactivity.bean.LoginBean;

/**
 * 作者: qgl
 * 创建日期：2021/10/30
 * 描述:邀请伙伴
 */
public interface IInvitePartnersModel {

    void inviteData(OnLoadListener loadListener);


    interface OnLoadListener {
        void showData(InvitePartnersBean bean);

        void showError(String msg);

        void showErrorToken(String msg);

    }

} 