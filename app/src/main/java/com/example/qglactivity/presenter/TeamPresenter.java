package com.example.qglactivity.presenter;

import com.example.qglactivity.bean.BusinessMessageBean;
import com.example.qglactivity.bean.TeamBean;
import com.example.qglactivity.model.BusinessMessageModel;
import com.example.qglactivity.model.IBusinessMessageModel;
import com.example.qglactivity.model.ITeamModel;
import com.example.qglactivity.model.TeamModel;
import com.example.qglactivity.view.BusinessMessageView;
import com.example.qglactivity.view.TeamView;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2021/11/3
 * 描述:我的伙伴
 */
public class TeamPresenter<T extends TeamView> extends BasePresenter{

    TeamModel teamModel = new TeamModel();

    public void isTeamList(String userId,int mCount,int pageSize,String nickName,String sortTime){
        ((T) iGoodsView.get()).showProgress();
        if (iGoodsView.get() != null && teamModel != null) {
            teamModel.isTeamData(userId, mCount, pageSize, nickName, sortTime, new ITeamModel.OnLoadListener() {
                @Override
                public void showData(TeamBean bean) {
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