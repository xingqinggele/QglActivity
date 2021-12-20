package com.example.qglactivity.presenter;

import android.content.Context;

import com.example.qglactivity.bean.InvitePartnersBean;
import com.example.qglactivity.bean.LoginBean;
import com.example.qglactivity.model.IInvitePartnersModel;
import com.example.qglactivity.model.ILoginModel;
import com.example.qglactivity.model.InvitePartnersModel;
import com.example.qglactivity.model.LoginModel;
import com.example.qglactivity.util.SPUtils;
import com.example.qglactivity.view.InvitePartnersView;
import com.example.qglactivity.view.LoginView;

/**
 * 作者: qgl
 * 创建日期：2021/10/30
 * 描述:邀请伙伴
 */
public class InvitePartnersPresenter<T extends InvitePartnersView> extends BasePresenter {
    InvitePartnersModel invitePartnersModel = new InvitePartnersModel();

    public void inviteParData() {
        ((T) iGoodsView.get()).showProgress();
        if (iGoodsView.get() != null && invitePartnersModel != null){
            invitePartnersModel.inviteData(new IInvitePartnersModel.OnLoadListener() {
                @Override
                public void showData(InvitePartnersBean bean) {
                    ((T) iGoodsView.get()).downProgress();
                    ((T) iGoodsView.get()).showInvite(bean);
                }

                @Override
                public void showError(String msg) {
                    ((T) iGoodsView.get()).downProgress();
                    ((T) iGoodsView.get()).showErrorMessage(msg);
                }

                @Override
                public void showErrorToken(String msg) {
                    ((T) iGoodsView.get()).downProgress();
                    ((T) iGoodsView.get()).showErrorToken(msg);
                }
            });
        }
    }
}