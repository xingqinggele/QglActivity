package com.example.qglactivity.bean;

/**
 * 作者: qgl
 * 创建日期：2021/11/3
 * 描述:我的
 */

public class MinePageBean {

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

    public static class DataBean {
        private Object monthlyTransAmount;
        private Object monthlyNewPartnerCounts;
        private Object monthlyNewMerchantCounts;
        private Object expressNews;
        private String nickName;
        private String merchCode;
        private Object secretId;
        private String secretKey;
        private Object bucketName;
        private String portrait;
        private Object servicePhone;
        private String integral;
        private String walletAmount;

        public Object getMonthlyTransAmount() {
            return monthlyTransAmount;
        }

        public void setMonthlyTransAmount(Object monthlyTransAmount) {
            this.monthlyTransAmount = monthlyTransAmount;
        }

        public Object getMonthlyNewPartnerCounts() {
            return monthlyNewPartnerCounts;
        }

        public void setMonthlyNewPartnerCounts(Object monthlyNewPartnerCounts) {
            this.monthlyNewPartnerCounts = monthlyNewPartnerCounts;
        }

        public Object getMonthlyNewMerchantCounts() {
            return monthlyNewMerchantCounts;
        }

        public void setMonthlyNewMerchantCounts(Object monthlyNewMerchantCounts) {
            this.monthlyNewMerchantCounts = monthlyNewMerchantCounts;
        }

        public Object getExpressNews() {
            return expressNews;
        }

        public void setExpressNews(Object expressNews) {
            this.expressNews = expressNews;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getMerchCode() {
            return merchCode;
        }

        public void setMerchCode(String merchCode) {
            this.merchCode = merchCode;
        }

        public Object getSecretId() {
            return secretId;
        }

        public void setSecretId(Object secretId) {
            this.secretId = secretId;
        }

        public String getSecretKey() {
            return secretKey;
        }

        public void setSecretKey(String secretKey) {
            this.secretKey = secretKey;
        }

        public Object getBucketName() {
            return bucketName;
        }

        public void setBucketName(Object bucketName) {
            this.bucketName = bucketName;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public Object getServicePhone() {
            return servicePhone;
        }

        public void setServicePhone(Object servicePhone) {
            this.servicePhone = servicePhone;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public String getWalletAmount() {
            return walletAmount;
        }

        public void setWalletAmount(String walletAmount) {
            this.walletAmount = walletAmount;
        }
    }
}