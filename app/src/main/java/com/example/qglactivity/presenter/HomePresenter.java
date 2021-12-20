package com.example.qglactivity.presenter;

import com.example.qglactivity.bean.HomeAdvBean;
import com.example.qglactivity.bean.HomePageBean;
import com.example.qglactivity.model.HomeModel;
import com.example.qglactivity.model.IHomeModel;
import com.example.qglactivity.view.HomeView;

/**
 * 作者: qgl
 * 创建日期：2021/11/1
 * 描述:首页P
 */
public class HomePresenter<T extends HomeView> extends BasePresenter {

    HomeModel homeModel = new HomeModel();

    /**
     * 请求首页数据
     * @param userId
     */
    public void HomePage(String userId) {
        ((T) iGoodsView.get()).showProgress();
        if (iGoodsView.get() != null && homeModel != null) {
            homeModel.iHome(userId, new IHomeModel.OnLoadListener() {
                @Override
                public void showData(HomePageBean bean) {
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


    /**
     * 请求轮播图
     */
    public void HomeBanner(){
        if (iGoodsView.get() != null && homeModel != null){
            homeModel.Banner(new IHomeModel.BeannerView() {
                @Override
                public void LoadSuccess(HomeAdvBean bean) {
                    ((T)iGoodsView.get()).BannerSuccess(bean);
                }

                @Override
                public void LoadFail(String message) {
                    ((T)iGoodsView.get()).BannerFail(message);

                }
            });
        }
    }


} 