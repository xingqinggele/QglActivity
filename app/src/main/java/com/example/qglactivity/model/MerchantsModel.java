package com.example.qglactivity.model;

import com.example.qglactivity.bean.BusinessMessageBean;
import com.example.qglactivity.bean.LoginBean;
import com.example.qglactivity.bean.MerchantsBean;
import com.example.qglactivity.net.HttpRequest;
import com.example.qglactivity.net.OkHttpException;
import com.example.qglactivity.net.RequestParams;
import com.example.qglactivity.net.ResponseCallback;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2021/11/3
 * 描述:
 */
public class MerchantsModel implements IMerchantsModel {

    @Override
    public void isMerchantsData(String userId, int mCount, int pageSize, String nikeName, String turnover, OnLoadListener loadListener) {
        RequestParams params = new RequestParams();
        params.put("userId", userId);
        params.put("pageNo", mCount + "");
        params.put("pageSize", pageSize + "");
        params.put("nickName", nikeName);
        params.put("orderly", turnover);
        HttpRequest.getMerchantsList(params, new ResponseCallback() {
            //成功回调
            @Override
            public void onSuccess(Object responseObj) {
                Gson gson = new GsonBuilder().serializeNulls().create();
                try {
                    JSONObject object = new JSONObject(responseObj.toString());
                    MerchantsBean merchantsBean = gson.fromJson(object.toString(), MerchantsBean.class);
                    loadListener.showData(merchantsBean);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            //失败回调
            @Override
            public void onFailure(OkHttpException okHttpException) {
                if (okHttpException.getfCode() == 401) {
                    loadListener.showErrorToken("登录过期，请重新登录");
                    return;
                }
                loadListener.showError(okHttpException.getfMsg());
            }
        });
    }
}