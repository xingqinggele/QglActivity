package com.example.qglactivity.presenter;

import com.example.qglactivity.bean.BusinessMessageBean;
import com.example.qglactivity.bean.DataPageBean;
import com.example.qglactivity.model.BusinessMessageModel;
import com.example.qglactivity.model.IBusinessMessageModel;
import com.example.qglactivity.model.IDataModel;
import com.example.qglactivity.view.BusinessMessageView;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2021/11/3
 * 描述:
 */
public class BusinessMessagePresenter<T extends BusinessMessageView> extends BasePresenter{

    BusinessMessageModel messageModel = new BusinessMessageModel();

    public void isMessageData(String userId,int mCount,int pageSize){
        ((T) iGoodsView.get()).showProgress();
        if (iGoodsView.get() != null && messageModel != null) {
            messageModel.isMessageData(userId,mCount,pageSize,new IBusinessMessageModel.OnLoadListener() {
                @Override
                public void showData(List<BusinessMessageBean> bean) {
                    ((T) iGoodsView.get()).downProgress();
                    ((T) iGoodsView.get()).showListData(bean);
                    if (bean.size() > pageSize){
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