package com.example.qglactivity.presenter;

import com.example.qglactivity.bean.DataPageBean;
import com.example.qglactivity.model.DataModel;
import com.example.qglactivity.model.IDataModel;
import com.example.qglactivity.view.DataView;

/**
 * 作者: qgl
 * 创建日期：2021/11/2
 * 描述:数据P
 */
public class DataPresenter<T extends DataView> extends BasePresenter{

    DataModel model = new DataModel();

    public void posData(){
        ((T) iGoodsView.get()).showProgress();
        if (iGoodsView.get() != null && model != null) {
            model.isDate(new IDataModel.OnLoadListener() {
                @Override
                public void showData(DataPageBean bean) {
                    ((T) iGoodsView.get()).downProgress();
                    ((T) iGoodsView.get()).showHomeData(bean);
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