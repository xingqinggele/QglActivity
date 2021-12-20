package com.example.qglactivity.model;

import com.example.qglactivity.bean.BusinessMessageBean;
import com.example.qglactivity.bean.DataPageBean;
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
public class BusinessMessageModel implements IBusinessMessageModel {


    @Override
    public void isMessageData(String userId, int mCount, int pageSize, OnLoadListener loadListener) {
        RequestParams params = new RequestParams();
        //用户ID
        params.put("userId", userId);
        //页码
        params.put("pageNo", mCount + "");
        //请求数据长度
        params.put("pageSize", pageSize + "");
        //请求
        HttpRequest.getMessageList(params, new ResponseCallback() {
            //成功回调
            @Override
            public void onSuccess(Object responseObj) {
                Gson gson = new GsonBuilder().serializeNulls().create();
                try {
                    JSONObject object = new JSONObject(responseObj.toString());
                    List<BusinessMessageBean> memberList = gson.fromJson(object.getJSONArray("data").toString(),
                            new TypeToken<List<BusinessMessageBean>>() {
                            }.getType());

                    loadListener.showData(memberList);

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