package com.example.qglactivity.net;

/**
 * 作者: qgl
 * 创建日期：2021/10/26
 * 描述:
 */
public class OkHttpException extends Exception{
    //错误码
    private int fCode;
    //错误消息
    private String fMsg;
    //构造器
    public OkHttpException(int fCode, String fMsg) {
        this.fCode = fCode;
        this.fMsg = fMsg;
    }

    public int getfCode() {
        return fCode;
    }

    public void setfCode(int fCode) {
        this.fCode = fCode;
    }

    public String getfMsg() {
        return fMsg;
    }

    public void setfMsg(String fMsg) {
        this.fMsg = fMsg;
    }
}