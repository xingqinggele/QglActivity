package com.example.qglactivity.model;

import com.example.qglactivity.bean.MinePageBean;
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
 * 创建日期：2021/11/2
 * 描述:我的M
 */
public class MineModel implements IMineModel {

    @Override
    public void isMine(String userId,OnLoadListener loadListener) {
        RequestParams params = new RequestParams();
        params.put("userId",userId);
        HttpRequest.getMeData(params,  new ResponseCallback() {
            @Override
            public void onSuccess(Object responseObj) {
                Gson gson = new GsonBuilder().serializeNulls().create();
                try {
                    JSONObject object = new JSONObject(responseObj.toString());
                    MinePageBean data = gson.fromJson(object.toString(), MinePageBean.class);
                    loadListener.showData(data);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

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
}