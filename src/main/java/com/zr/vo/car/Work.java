package com.zr.vo.car;

import java.math.BigDecimal;
import java.util.Date;

public class Work {
    private Long id;

    private Long orderId;

    private String carNo;

    private Date outTime;

    private Date inTime;

    private String outUserId;

    private String inUserId;

    private Date outFitTime;

    private String outFitUserId;

    private String status;

    private BigDecimal total;

    private String mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo == null ? null : carNo.trim();
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public String getOutUserId() {
        return outUserId;
    }

    public void setOutUserId(String outUserId) {
        this.outUserId = outUserId == null ? null : outUserId.trim();
    }

    public String getInUserId() {
        return inUserId;
    }

    public void setInUserId(String inUserId) {
        this.inUserId = inUserId == null ? null : inUserId.trim();
    }

    public Date getOutFitTime() {
        return outFitTime;
    }

    public void setOutFitTime(Date outFitTime) {
        this.outFitTime = outFitTime;
    }

    public String getOutFitUserId() {
        return outFitUserId;
    }

    public void setOutFitUserId(String outFitUserId) {
        this.outFitUserId = outFitUserId == null ? null : outFitUserId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}