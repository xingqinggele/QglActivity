package com.example.qglactivity.model;

import com.example.qglactivity.bean.HomeAdvBean;
import com.example.qglactivity.bean.HomePageBean;
import com.example.qglactivity.net.HttpRequest;
import com.example.qglactivity.net.OkHttpException;
import com.example.qglactivity.net.RequestParams;
import com.example.qglactivity.net.ResponseCallback;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 作者: qgl
 * 创建日期：2021/11/1
 * 描述:首页model
 */
public class HomeModel implements IHomeModel {

    /**
     * 请求首页数据
     *
     * @param userId
     * @param loadListener
     */
    @Override
    public void iHome(String userId, OnLoadListener loadListener) {
        RequestParams params = new RequestParams();
        //用户ID
        params.put("userId", userId);
        //发起 params、token 、回调
        HttpRequest.getHomeDate(params, new ResponseCallback() {
            //返回成功
            @Override
            public void onSuccess(Object responseObj) {
                Gson gson = new GsonBuilder().serializeNulls().create();
                try {
                    JSONObject object = new JSONObject(responseObj.toString());
                    HomePageBean data = gson.fromJson(object.toString(), HomePageBean.class);
                    loadListener.showData(data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            //返回失败
            @Override
            public void onFailure(OkHttpException okHttpException) {
                if (okHttpException.getfCode() == 401) {
                    loadListener.showErrorToken("登录过期，请重新登录");
                    return;
                }
                if (okHttpException.getfCode() == 500001) {
                    loadListener.NoRealName();
                    return;
                }

                loadListener.showError(okHttpException.getfMsg());
            }
        });

    }

    /**
     * 请求轮播图
     *
     * @param loadListener
     */
    @Override
    public void Banner(BeannerView loadListener) {
        RequestParams params = new RequestParams();
        HttpRequest.getAdvertising(params, new ResponseCallback() {
            @Override
            public void onSuccess(Object responseObj) {
                Gson gson = new GsonBuilder().serializeNulls().create();
                try {
                    JSONObject result = new JSONObject(responseObj.toString());
                    HomeAdvBean data = gson.fromJson(result.toString(), HomeAdvBean.class);
                    loadListener.LoadSuccess(data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(OkHttpException okHttpException) {
                loadListener.LoadFail(okHttpException.getfMsg());
            }
        });
    }


}