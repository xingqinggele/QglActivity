package com.example.qglactivity.bean;

import java.math.BigDecimal;

/**
 * 作者: qgl
 * 创建日期：2021/11/1
 * 描述:首页Bean
 */

public class HomePageBean {
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
        private BigDecimal monthlyTransAmount;
        private int monthlyNewPartnerCounts;
        private int monthlyNewMerchantCounts;
        private Object expressNews;
        private String nickName;
        private String merchCode;
        private String secretId;
        private String secretKey;
        private String bucketName;
        private String portrait;
        private String servicePhone;
        private Object integral;
        private Object walletAmount;

        public BigDecimal getMonthlyTransAmount() {
            return monthlyTransAmount;
        }

        public void setMonthlyTransAmount(BigDecimal monthlyTransAmount) {
            this.monthlyTransAmount = monthlyTransAmount;
        }

        public int getMonthlyNewPartnerCounts() {
            return monthlyNewPartnerCounts;
        }

        public void setMonthlyNewPartnerCounts(int monthlyNewPartnerCounts) {
            this.monthlyNewPartnerCounts = monthlyNewPartnerCounts;
        }

        public int getMonthlyNewMerchantCounts() {
            return monthlyNewMerchantCounts;
        }

        public void setMonthlyNewMerchantCounts(int monthlyNewMerchantCounts) {
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

        public String getSecretId() {
            return secretId;
        }

        public void setSecretId(String secretId) {
            this.secretId = secretId;
        }

        public String getSecretKey() {
            return secretKey;
        }

        public void setSecretKey(String secretKey) {
            this.secretKey = secretKey;
        }

        public String getBucketName() {
            return bucketName;
        }

        public void setBucketName(String bucketName) {
            this.bucketName = bucketName;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public String getServicePhone() {
            return servicePhone;
        }

        public void setServicePhone(String servicePhone) {
            this.servicePhone = servicePhone;
        }

        public Object getIntegral() {
            return integral;
        }

        public void setIntegral(Object integral) {
            this.integral = integral;
        }

        public Object getWalletAmount() {
            return walletAmount;
        }

        public void setWalletAmount(Object walletAmount) {
            this.walletAmount = walletAmount;
        }
    }


}