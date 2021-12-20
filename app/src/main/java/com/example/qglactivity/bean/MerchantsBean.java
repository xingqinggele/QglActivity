package com.example.qglactivity.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2021/11/16
 * 描述:我的商户
 */

public class MerchantsBean implements Serializable {
    private String msg;
    private int code;
    private List<DataBean> data;
    private int num;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public static class DataBean {
        private String merchantName;
        private String transAmount;
        private String id;
        private Object merchCode;
        private Object snCode;
        private Object activeTime;
        private Object netTime;
        private String queryMonth;

        public String getMerchantName() {
            return merchantName;
        }

        public void setMerchantName(String merchantName) {
            this.merchantName = merchantName;
        }

        public String getTransAmount() {
            return transAmount;
        }

        public void setTransAmount(String transAmount) {
            this.transAmount = transAmount;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getMerchCode() {
            return merchCode;
        }

        public void setMerchCode(Object merchCode) {
            this.merchCode = merchCode;
        }

        public Object getSnCode() {
            return snCode;
        }

        public void setSnCode(Object snCode) {
            this.snCode = snCode;
        }

        public Object getActiveTime() {
            return activeTime;
        }

        public void setActiveTime(Object activeTime) {
            this.activeTime = activeTime;
        }

        public Object getNetTime() {
            return netTime;
        }

        public void setNetTime(Object netTime) {
            this.netTime = netTime;
        }

        public String getQueryMonth() {
            return queryMonth;
        }

        public void setQueryMonth(String queryMonth) {
            this.queryMonth = queryMonth;
        }
    }
}