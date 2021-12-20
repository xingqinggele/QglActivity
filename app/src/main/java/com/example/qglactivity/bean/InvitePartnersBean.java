package com.example.qglactivity.bean;

/**
 * 作者: qgl
 * 创建日期：2021/11/19
 * 描述:邀请伙伴
 */

public class InvitePartnersBean {


    private String msg;
    private int code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "InvitePartnersBean{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        private String merchCode;
        private String url;

        public String getMerchCode() {
            return merchCode;
        }

        public void setMerchCode(String merchCode) {
            this.merchCode = merchCode;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "merchCode='" + merchCode + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}