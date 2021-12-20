package com.example.qglactivity.view;

import com.example.qglactivity.bean.InvitePartnersBean;
import com.example.qglactivity.bean.LoginBean;

/**
 * 作者: qgl
 * 创建日期：2021/10/30
 * 描述:邀请伙伴
 */
public interface InvitePartnersView extends IBaseView {
    //显示数据
    void showInvite(InvitePartnersBean bean);

    //token错误
    void showErrorToken(String msg);
}