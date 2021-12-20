package com.example.qglactivity.net;

/**
 * 作者: qgl
 * 创建日期：2021/10/26
 * 描述:请求接口存放类
 */
public class HttpRequest {

    /**
     * 登录接口
     *
     * @param params
     * @param callback
     */
    public static void getLogin(RequestParams params, ResponseCallback callback) {
        RequestMode.posRequest(ApiService.commUrls + "login", params, callback, null);
    }

    /**
     * 排行榜
     *
     * @param params
     * @param callback
     */
    public static void getRanking(RequestParams params,ResponseCallback callback) {
        RequestMode.posRequest(ApiService.commUrls + "pos/api/v2/homepage/ranking", params, callback,null);
    }


    /**
     * 首页数据接口
     *
     * @param params
     * @param callback
     */
    public static void getHomeDate(RequestParams params, ResponseCallback callback) {
        RequestMode.posRequest(ApiService.commUrls + "pos/api/v2/homepage/data", params, callback, null);
    }

    /**
     * 广告位
     *
     * @param params
     * @param callback
     */
    public static void getAdvertising(RequestParams params,  ResponseCallback callback) {
        RequestMode.posRequest(ApiService.commUrls + "pos/api/v2/advertising/getAdvertising", params,  callback, null);
    }


    /**
     * 获取数据页，数据
     *
     * @param params
     * @param callback
     */
    public static void getTransAmount(RequestParams params, ResponseCallback callback) {
        RequestMode.posRequest(ApiService.commUrls + "pos/api/v2/homepage/transAmountStatistics", params, callback, null);
    }

    /**
     * 我的
     *
     * @param params
     * @param callback
     */
    public static void getMeData(RequestParams params,  ResponseCallback callback) {
        RequestMode.posRequest(ApiService.commUrls + "pos/api/v2/homepage/dataInfo", params, callback, null);
    }

    /**
     * 消息列表
     *
     * @param params
     * @param callback
     */
    public static void getMessageList(RequestParams params, ResponseCallback callback) {
        RequestMode.posRequest(ApiService.commUrls + "pos/api/v2/message/list", params,callback, null);
    }

    /**
     * 获取我的商户列表
     *
     * @param params
     * @param callback
     */
    public static void getMerchantsList(RequestParams params, ResponseCallback callback) {
        RequestMode.posRequest(ApiService.commUrls + "pos/api/v2/merchant/queryMerchantInfo", params,callback, null);
    }

    /**
     * 邀请伙伴
     *
     * @param params
     * @param callback
     */
    public static void getInvitationPartner(RequestParams params, ResponseCallback callback) {
        RequestMode.posRequest(ApiService.commUrls + "pos/api/v2/merchant/mypartner/invite", params, callback, null);
    }

    /**
     * 获取我的伙伴列表
     *
     * @param params
     * @param callback
     */
    public static void updMypartnerList(RequestParams params,ResponseCallback callback) {
        RequestMode.posRequest(ApiService.commUrls + "pos/api/v2/merchant/mypartner/list", params, callback, null);
    }


    /**
     * 获取用户终端统计数据
     *
     * @param params
     * @param callback
     */
    public static void getEquipmentData(RequestParams params, ResponseCallback callback) {
        RequestMode.posRequest(ApiService.commUrls + "pos/api/v2/terminal/counts", params, callback, null);
    }
} 