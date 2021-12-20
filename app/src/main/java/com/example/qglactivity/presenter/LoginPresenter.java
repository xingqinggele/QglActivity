package com.example.qglactivity.presenter;

import android.content.Context;

import com.example.qglactivity.bean.LoginBean;
import com.example.qglactivity.model.ILoginModel;
import com.example.qglactivity.model.LoginModel;
import com.example.qglactivity.util.SPUtils;
import com.example.qglactivity.view.LoginView;

/**
 * 作者: qgl
 * 创建日期：2021/10/30
 * 描述:
 */
public class LoginPresenter<T extends LoginView> extends BasePresenter {
    ILoginModel loginModel = new LoginModel();

    /**
     * 登录P
     * @param context
     * @param checked  是否记住
     * @param userName
     * @param passWord
     */
    public void login(Context context, boolean checked, String userName, String passWord) {
        ((T) iGoodsView.get()).showProgress();
        if (iGoodsView.get() != null && loginModel != null) {
            loginModel.iLogin(userName, passWord, new ILoginModel.OnLoadListener() {
                @Override
                public void showData(LoginBean bean) {
                    ((T) iGoodsView.get()).downProgress();
                    //本地存储用户名
                    SPUtils.put(context, "userName", bean.getLoginUser().getUser().getUserName());
                    //如果用户点击记住密码、存储密码到本地
                    if (checked) {
                        //本地存储密码
                        SPUtils.put(context, "passWord", passWord);
                    }
                    SPUtils.put(context, "ticket", bean.getTicket());
                    SPUtils.put(context, "userId", bean.getLoginUser().getUser().getUserId());
                    SPUtils.put(context, "secretId", bean.getSecretId());
                    SPUtils.put(context, "secretKey", bean.getSecretKey());
                    SPUtils.put(context, "bucketName", bean.getBucketName());
                    SPUtils.put(context, "createTime", bean.getLoginUser().getUser().getCreateTime());
                    SPUtils.put(context, "Token", bean.getToken());
                    ((T) iGoodsView.get()).showGoodList(bean);
                }

                @Override
                public void showError(String msg) {
                    ((T) iGoodsView.get()).downProgress();
                    ((T) iGoodsView.get()).showErrorMessage(msg);
                }
            });
        }

    }
} 