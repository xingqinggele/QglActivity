package com.example.qglactivity.presenter;

import com.example.qglactivity.bean.HomePageBean;
import com.example.qglactivity.bean.MinePageBean;
import com.example.qglactivity.model.IHomeModel;
import com.example.qglactivity.model.IMineModel;
import com.example.qglactivity.model.MineModel;
import com.example.qglactivity.view.MineView;

/**
 * 作者: qgl
 * 创建日期：2021/11/3
 * 描述:我的
 */
public class MinePresenter<T extends MineView> extends BasePresenter {


    MineModel mineModel = new MineModel();


    public void posMine(String userId) {
        ((T) iGoodsView.get()).showProgress();

        if (iGoodsView.get() != null && mineModel != null) {
            mineModel.isMine(userId, new IMineModel.OnLoadListener() {
                @Override
                public void showData(MinePageBean bean) {
                    ((T) iGoodsView.get()).downProgress();
                    ((T) iGoodsView.get()).showMineData(bean);
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

                @Override
                public void NoRealName() {
                    ((T) iGoodsView.get()).downProgress();
                    ((T) iGoodsView.get()).NoRealName();
                }
            });
        }
    }

} 