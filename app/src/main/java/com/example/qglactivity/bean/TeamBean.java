package com.example.qglactivity.bean;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2021/11/19
 * 描述:我的伙伴
 */

public class TeamBean {

    private String msg;
    private int partnerCounts;
    private int code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getPartnerCounts() {
        return partnerCounts;
    }

    public void setPartnerCounts(int partnerCounts) {
        this.partnerCounts = partnerCounts;
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

    public static class DataBean {
        private int parnterId;
        private String partnerName;
        private String partnerMobile;
        private Object registerTime;
        private double teamTransAmount;
        private Object lastMonthTeamTransAmount;
        private int teamActiveCounts;
        private Object lastMonthTeamActiveCounts;
        private Object teamActiveMachines;
        private Object lastMonthteamActiveMacines;
        private Object partnerCounts;
        private String portrait;
        private Object count;
        private Object userId;
        private Object merchId;
        private Object thisDate;
        private Object lastDate;
        private Object today;
        private Object todayPartnerCounts;
        private Object todayteamActiveMacines;
        private Object todayTeamsTransAmount;
        private Object transAmountList;
        private Object activeMachinesList;

        public int getParnterId() {
            return parnterId;
        }

        public void setParnterId(int parnterId) {
            this.parnterId = parnterId;
        }

        public String getPartnerName() {
            return partnerName;
        }

        public void setPartnerName(String partnerName) {
            this.partnerName = partnerName;
        }

        public String getPartnerMobile() {
            return partnerMobile;
        }

        public void setPartnerMobile(String partnerMobile) {
            this.partnerMobile = partnerMobile;
        }

        public Object getRegisterTime() {
            return registerTime;
        }

        public void setRegisterTime(Object registerTime) {
            this.registerTime = registerTime;
        }

        public double getTeamTransAmount() {
            return teamTransAmount;
        }

        public void setTeamTransAmount(double teamTransAmount) {
            this.teamTransAmount = teamTransAmount;
        }

        public Object getLastMonthTeamTransAmount() {
            return lastMonthTeamTransAmount;
        }

        public void setLastMonthTeamTransAmount(Object lastMonthTeamTransAmount) {
            this.lastMonthTeamTransAmount = lastMonthTeamTransAmount;
        }

        public int getTeamActiveCounts() {
            return teamActiveCounts;
        }

        public void setTeamActiveCounts(int teamActiveCounts) {
            this.teamActiveCounts = teamActiveCounts;
        }

        public Object getLastMonthTeamActiveCounts() {
            return lastMonthTeamActiveCounts;
        }

        public void setLastMonthTeamActiveCounts(Object lastMonthTeamActiveCounts) {
            this.lastMonthTeamActiveCounts = lastMonthTeamActiveCounts;
        }

        public Object getTeamActiveMachines() {
            return teamActiveMachines;
        }

        public void setTeamActiveMachines(Object teamActiveMachines) {
            this.teamActiveMachines = teamActiveMachines;
        }

        public Object getLastMonthteamActiveMacines() {
            return lastMonthteamActiveMacines;
        }

        public void setLastMonthteamActiveMacines(Object lastMonthteamActiveMacines) {
            this.lastMonthteamActiveMacines = lastMonthteamActiveMacines;
        }

        public Object getPartnerCounts() {
            return partnerCounts;
        }

        public void setPartnerCounts(Object partnerCounts) {
            this.partnerCounts = partnerCounts;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public Object getCount() {
            return count;
        }

        public void setCount(Object count) {
            this.count = count;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public Object getMerchId() {
            return merchId;
        }

        public void setMerchId(Object merchId) {
            this.merchId = merchId;
        }

        public Object getThisDate() {
            return thisDate;
        }

        public void setThisDate(Object thisDate) {
            this.thisDate = thisDate;
        }

        public Object getLastDate() {
            return lastDate;
        }

        public void setLastDate(Object lastDate) {
            this.lastDate = lastDate;
        }

        public Object getToday() {
            return today;
        }

        public void setToday(Object today) {
            this.today = today;
        }

        public Object getTodayPartnerCounts() {
            return todayPartnerCounts;
        }

        public void setTodayPartnerCounts(Object todayPartnerCounts) {
            this.todayPartnerCounts = todayPartnerCounts;
        }

        public Object getTodayteamActiveMacines() {
            return todayteamActiveMacines;
        }

        public void setTodayteamActiveMacines(Object todayteamActiveMacines) {
            this.todayteamActiveMacines = todayteamActiveMacines;
        }

        public Object getTodayTeamsTransAmount() {
            return todayTeamsTransAmount;
        }

        public void setTodayTeamsTransAmount(Object todayTeamsTransAmount) {
            this.todayTeamsTransAmount = todayTeamsTransAmount;
        }

        public Object getTransAmountList() {
            return transAmountList;
        }

        public void setTransAmountList(Object transAmountList) {
            this.transAmountList = transAmountList;
        }

        public Object getActiveMachinesList() {
            return activeMachinesList;
        }

        public void setActiveMachinesList(Object activeMachinesList) {
            this.activeMachinesList = activeMachinesList;
        }
    }
}