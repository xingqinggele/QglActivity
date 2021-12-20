package com.example.qglactivity.bean;

import java.util.List;

/**
 * 创建：  qgl
 * 时间：
 * 描述：首页广告位
 */

public class HomeAdvBean {
    private String msg;
    private int code;
    private List<Data2Bean> data2;
    private List<Data1Bean> data1;
    private List<Data0Bean> data0;

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

    public List<Data2Bean> getData2() {
        return data2;
    }

    public void setData2(List<Data2Bean> data2) {
        this.data2 = data2;
    }

    public List<Data1Bean> getData1() {
        return data1;
    }

    public void setData1(List<Data1Bean> data1) {
        this.data1 = data1;
    }

    public List<Data0Bean> getData0() {
        return data0;
    }

    public void setData0(List<Data0Bean> data0) {
        this.data0 = data0;
    }

    public static class Data2Bean {
        private String advPicture;
        private int advType;
        private Object advSort;
        private String newsUrl;
        private String newsTitle;

        public String getAdvPicture() {
            return advPicture;
        }

        public void setAdvPicture(String advPicture) {
            this.advPicture = advPicture;
        }

        public int getAdvType() {
            return advType;
        }

        public void setAdvType(int advType) {
            this.advType = advType;
        }

        public Object getAdvSort() {
            return advSort;
        }

        public void setAdvSort(Object advSort) {
            this.advSort = advSort;
        }

        public String getNewsUrl() {
            return newsUrl;
        }

        public void setNewsUrl(String newsUrl) {
            this.newsUrl = newsUrl;
        }

        public String getNewsTitle() {
            return newsTitle;
        }

        public void setNewsTitle(String newsTitle) {
            this.newsTitle = newsTitle;
        }
    }


    public static class Data1Bean {
        private String advPicture;
        private int advType;
        private Object advSort;
        private String newsUrl;
        private Object newsTitle;

        public String getAdvPicture() {
            return advPicture;
        }

        public void setAdvPicture(String advPicture) {
            this.advPicture = advPicture;
        }

        public int getAdvType() {
            return advType;
        }

        public void setAdvType(int advType) {
            this.advType = advType;
        }

        public Object getAdvSort() {
            return advSort;
        }

        public void setAdvSort(Object advSort) {
            this.advSort = advSort;
        }

        public String getNewsUrl() {
            return newsUrl;
        }

        public void setNewsUrl(String newsUrl) {
            this.newsUrl = newsUrl;
        }

        public Object getNewsTitle() {
            return newsTitle;
        }

        public void setNewsTitle(Object newsTitle) {
            this.newsTitle = newsTitle;
        }
    }

    public static class Data0Bean {
        private String advPicture;
        private int advType;
        private Object advSort;
        private String newsUrl;
        private String newsTitle;

        public String getAdvPicture() {
            return advPicture;
        }

        public void setAdvPicture(String advPicture) {
            this.advPicture = advPicture;
        }

        public int getAdvType() {
            return advType;
        }

        public void setAdvType(int advType) {
            this.advType = advType;
        }

        public Object getAdvSort() {
            return advSort;
        }

        public void setAdvSort(Object advSort) {
            this.advSort = advSort;
        }

        public String getNewsUrl() {
            return newsUrl;
        }

        public void setNewsUrl(String newsUrl) {
            this.newsUrl = newsUrl;
        }

        public String getNewsTitle() {
            return newsTitle;
        }

        public void setNewsTitle(String newsTitle) {
            this.newsTitle = newsTitle;
        }
    }
}
