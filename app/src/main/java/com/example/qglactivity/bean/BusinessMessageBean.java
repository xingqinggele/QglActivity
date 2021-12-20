package com.example.qglactivity.bean;

import java.util.List;

/**
 * 作者: qgl
 * 创建日期：2021/11/3
 * 描述:业务消息Bean
 */

public class BusinessMessageBean {


    private Object userId;
    private Object userIds;
    private int msgType;
    private int msgId;
    private int msgUserId;
    private String msgContent;
    private int msgStatus;
    private int readStatus;
    private String createTime;
    private int adviceType;
    private Object orderStatus;
    private Object orderId;
    private Object orderNo;
    private Object pageNo;
    private Object pageSize;
    private Object start;

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public Object getUserIds() {
        return userIds;
    }

    public void setUserIds(Object userIds) {
        this.userIds = userIds;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public int getMsgUserId() {
        return msgUserId;
    }

    public void setMsgUserId(int msgUserId) {
        this.msgUserId = msgUserId;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public int getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(int msgStatus) {
        this.msgStatus = msgStatus;
    }

    public int getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(int readStatus) {
        this.readStatus = readStatus;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getAdviceType() {
        return adviceType;
    }

    public void setAdviceType(int adviceType) {
        this.adviceType = adviceType;
    }

    public Object getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Object orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Object getOrderId() {
        return orderId;
    }

    public void setOrderId(Object orderId) {
        this.orderId = orderId;
    }

    public Object getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Object orderNo) {
        this.orderNo = orderNo;
    }

    public Object getPageNo() {
        return pageNo;
    }

    public void setPageNo(Object pageNo) {
        this.pageNo = pageNo;
    }

    public Object getPageSize() {
        return pageSize;
    }

    public void setPageSize(Object pageSize) {
        this.pageSize = pageSize;
    }

    public Object getStart() {
        return start;
    }

    public void setStart(Object start) {
        this.start = start;
    }
}