package com.example.qglactivity.model;
import com.example.qglactivity.bean.LoginBean;
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
 * 创建日期：2021/10/30
 * 描述:登录
 */
public class LoginModel implements ILoginModel{
    @Override
    public void iLogin(String userName, String passWord, OnLoadListener loadListener) {
        RequestParams params = new RequestParams();
        params.put("username",userName);
        params.put("password",passWord);
        HttpRequest.getLogin(params, new ResponseCallback() {
            @Override
            public void onSuccess(Object responseObj) {
                Gson gson = new GsonBuilder().serializeNulls().create();
                try {
                    JSONObject object = new JSONObject(responseObj.toString());
                    LoginBean data = gson.fromJson(object.toString(), LoginBean.class);
                    loadListener.showData(data);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(OkHttpException okHttpException) {
                    loadListener.showError(okHttpException.getfMsg());
            }
        });
    }
}