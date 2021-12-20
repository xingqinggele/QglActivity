package com.example.qglactivity.presenter;

import com.example.qglactivity.bean.EquipmentBean;
import com.example.qglactivity.bean.HomeAdvBean;
import com.example.qglactivity.bean.HomePageBean;
import com.example.qglactivity.model.EquipmentModel;
import com.example.qglactivity.model.HomeModel;
import com.example.qglactivity.model.IHomeModel;
import com.example.qglactivity.view.EquipmentView;
import com.example.qglactivity.view.HomeView;

/**
 * 作者: qgl
 * 创建日期：2021/11/1
 * 描述:首页P
 */
public class EquipmentPresenter<T extends EquipmentView> extends BasePresenter {

    EquipmentModel equipmentModel = new EquipmentModel();


    public void EquipmentData(String userId) {
        ((T) iGoodsView.get()).showProgress();
        if (iGoodsView.get() != null && equipmentModel != null) {
            equipmentModel.isEquipmentData(userId, new EquipmentModel.OnLoadListener() {
                @Override
                public void showData(EquipmentBean bean) {
                    ((T) iGoodsView.get()).downProgress();
                    ((T) iGoodsView.get()).showEquipmentData(bean);
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