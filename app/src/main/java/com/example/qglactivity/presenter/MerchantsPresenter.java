package com.example.qglactivity.presenter;

import com.example.qglactivity.bean.BusinessMessageBean;
import com.example.qglactivity.bean.MerchantsBean;
import com.example.qglactivity.model.BusinessMessageModel;
import com.example.qglactivity.model.IBusinessMessageModel;
import com.example.qglactivity.model.IMerchantsModel;
import com.example.qglactivity.model.MerchantsModel;
import com.example.qglactivity.view.BusinessMessageView;
import com.example.qglactivity.view.MerchantsView;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2021/11/3
 * 描述:我的商户
 */
public class MerchantsPresenter<T extends MerchantsView> extends BasePresenter{

    MerchantsModel messageModel = new MerchantsModel();

    public void isMerchantsData(String userId,int mCount,int pageSize,String nikeName,String turnover){
        ((T) iGoodsView.get()).showProgress();
        if (iGoodsView.get() != null && messageModel != null) {
            messageModel.isMerchantsData(userId,mCount,pageSize,nikeName, turnover,new IMerchantsModel.OnLoadListener() {
                @Override
                public void showData(MerchantsBean bean) {
                    ((T) iGoodsView.get()).downProgress();
                    ((T) iGoodsView.get()).showListData(bean);
                    if (bean.getData().size() > pageSize){
                        ((T) iGoodsView.get()).loadMoreComplete();
                    }else {
                        ((T) iGoodsView.get()).loadMoreEnd();
                    }
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