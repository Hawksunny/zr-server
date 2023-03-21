package com.zr.vo.lease;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.vo.BaseVo;

import java.math.BigDecimal;
import java.util.Date;

public class OrderForOrderPage extends BaseVo {

    private Long orderId;

    private String customerId;

    private String customerName;

    private Long carId;

    private String carName;

    private String fromCityName;

    private String fromShopName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date fromTime;

    private String toCityName;

    private String toShopName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date toTime;

    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date orderTime;

    private String agreementName;

    private String nomp;

    private String psur;

    private BigDecimal total;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getFromCityName() {
        return fromCityName;
    }

    public void setFromCityName(String fromCityName) {
        this.fromCityName = fromCityName;
    }

    public String getFromShopName() {
        return fromShopName;
    }

    public void setFromShopName(String fromShopName) {
        this.fromShopName = fromShopName;
    }

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public String getToCityName() {
        return toCityName;
    }

    public void setToCityName(String toCityName) {
        this.toCityName = toCityName;
    }

    public String getToShopName() {
        return toShopName;
    }

    public void setToShopName(String toShopName) {
        this.toShopName = toShopName;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getAgreementName() {
        return agreementName;
    }

    public void setAgreementName(String agreementName) {
        this.agreementName = agreementName;
    }

    public String getNomp() {
        return nomp;
    }

    public void setNomp(String nomp) {
        this.nomp = nomp;
    }

    public String getPsur() {
        return psur;
    }

    public void setPsur(String psur) {
        this.psur = psur;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
