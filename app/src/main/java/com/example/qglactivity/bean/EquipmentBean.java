package com.example.qglactivity.bean;

/**
 * 作者: qgl
 * 创建日期：2021/11/19
 * 描述:终端管理
 */

public class EquipmentBean {

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
        private int merchId;
        private int userId;
        private int terminalCounts;
        private int terminalActivatedCounts;
        private int terminalNoActivateCounts;

        public int getMerchId() {
            return merchId;
        }

        public void setMerchId(int merchId) {
            this.merchId = merchId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getTerminalCounts() {
            return terminalCounts;
        }

        public void setTerminalCounts(int terminalCounts) {
            this.terminalCounts = terminalCounts;
        }

        public int getTerminalActivatedCounts() {
            return terminalActivatedCounts;
        }

        public void setTerminalActivatedCounts(int terminalActivatedCounts) {
            this.terminalActivatedCounts = terminalActivatedCounts;
        }

        public int getTerminalNoActivateCounts() {
            return terminalNoActivateCounts;
        }

        public void setTerminalNoActivateCounts(int terminalNoActivateCounts) {
            this.terminalNoActivateCounts = terminalNoActivateCounts;
        }
    }
}