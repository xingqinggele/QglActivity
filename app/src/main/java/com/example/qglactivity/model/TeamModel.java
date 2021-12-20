package com.example.qglactivity.model;

import com.example.qglactivity.bean.BusinessMessageBean;
import com.example.qglactivity.bean.TeamBean;
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
 * 描述:我的伙伴
 */
public class TeamModel implements ITeamModel {


    @Override
    public void isTeamData(String userId, int mCount, int pageSize, String nickName,String sortTime,OnLoadListener loadListener) {
        RequestParams params = new RequestParams();
        params.put("userId", userId);
        params.put("pageNo", mCount + "");
        params.put("pageSize", pageSize + "");
        params.put("nickName", nickName);
        params.put("sortTime", sortTime + "");
        HttpRequest.updMypartnerList(params, new ResponseCallback() {
            @Override
            public void onSuccess(Object responseObj) {
                Gson gson = new GsonBuilder().serializeNulls().create();
                try {
                    JSONObject object = new JSONObject(responseObj.toString());
                    TeamBean teamBean = gson.fromJson(object.toString(),TeamBean.class);
                    loadListener.showData(teamBean);

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
                loadListener.showError(okHttpException.getfMsg());
            }
        });
    }
}