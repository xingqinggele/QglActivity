package com.example.qglactivity.bean;

import java.math.BigDecimal;

/**
 * 作者: qgl
 * 创建日期：2021/11/2
 * 描述:数据Bean
 */

public class DataPageBean {

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
        private String totalPartnerCounts;
        private int monthlyNewMerchantCounts;
        private String totalMerchantCounts;
        private BigDecimal merchantTransAmount;
        private BigDecimal partnerTransAmount;
        private int ownTotalParentCounts;
        private int ownTotalMerchantCounts;
        private int parentTotalMerchantCounts;
        private int parentTotalParentCounts;
        private int allMerchantCounts;
        private int allParentsCounts;

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

        public String getTotalPartnerCounts() {
            return totalPartnerCounts;
        }

        public void setTotalPartnerCounts(String totalPartnerCounts) {
            this.totalPartnerCounts = totalPartnerCounts;
        }

        public int getMonthlyNewMerchantCounts() {
            return monthlyNewMerchantCounts;
        }

        public void setMonthlyNewMerchantCounts(int monthlyNewMerchantCounts) {
            this.monthlyNewMerchantCounts = monthlyNewMerchantCounts;
        }

        public String getTotalMerchantCounts() {
            return totalMerchantCounts;
        }

        public void setTotalMerchantCounts(String totalMerchantCounts) {
            this.totalMerchantCounts = totalMerchantCounts;
        }

        public BigDecimal getMerchantTransAmount() {
            return merchantTransAmount;
        }

        public void setMerchantTransAmount(BigDecimal merchantTransAmount) {
            this.merchantTransAmount = merchantTransAmount;
        }

        public BigDecimal getPartnerTransAmount() {
            return partnerTransAmount;
        }

        public void setPartnerTransAmount(BigDecimal partnerTransAmount) {
            this.partnerTransAmount = partnerTransAmount;
        }

        public int getOwnTotalParentCounts() {
            return ownTotalParentCounts;
        }

        public void setOwnTotalParentCounts(int ownTotalParentCounts) {
            this.ownTotalParentCounts = ownTotalParentCounts;
        }

        public int getOwnTotalMerchantCounts() {
            return ownTotalMerchantCounts;
        }

        public void setOwnTotalMerchantCounts(int ownTotalMerchantCounts) {
            this.ownTotalMerchantCounts = ownTotalMerchantCounts;
        }

        public int getParentTotalMerchantCounts() {
            return parentTotalMerchantCounts;
        }

        public void setParentTotalMerchantCounts(int parentTotalMerchantCounts) {
            this.parentTotalMerchantCounts = parentTotalMerchantCounts;
        }

        public int getParentTotalParentCounts() {
            return parentTotalParentCounts;
        }

        public void setParentTotalParentCounts(int parentTotalParentCounts) {
            this.parentTotalParentCounts = parentTotalParentCounts;
        }

        public int getAllMerchantCounts() {
            return allMerchantCounts;
        }

        public void setAllMerchantCounts(int allMerchantCounts) {
            this.allMerchantCounts = allMerchantCounts;
        }

        public int getAllParentsCounts() {
            return allParentsCounts;
        }

        public void setAllParentsCounts(int allParentsCounts) {
            this.allParentsCounts = allParentsCounts;
        }
    }
}