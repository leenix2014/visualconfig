package com.dszy.visualconfig.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "s_app_store", schema = "shoppingcenter", catalog = "")
public class SAppStoreEntity {
    private int id;
    private String productId;
    private String payWay;
    private int storeId;
    private int wxPay;
    private int applePay;
    private int aliPay;
    private String appleChannelCode;
    private int sortId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "productId")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "payWay")
    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    @Basic
    @Column(name = "storeId")
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "wxPay")
    public int getWxPay() {
        return wxPay;
    }

    public void setWxPay(int wxPay) {
        this.wxPay = wxPay;
    }

    @Basic
    @Column(name = "applePay")
    public int getApplePay() {
        return applePay;
    }

    public void setApplePay(int applePay) {
        this.applePay = applePay;
    }

    @Basic
    @Column(name = "aliPay")
    public int getAliPay() {
        return aliPay;
    }

    public void setAliPay(int aliPay) {
        this.aliPay = aliPay;
    }

    @Basic
    @Column(name = "appleChannelCode")
    public String getAppleChannelCode() {
        return appleChannelCode;
    }

    public void setAppleChannelCode(String appleChannelCode) {
        this.appleChannelCode = appleChannelCode;
    }

    @Basic
    @Column(name = "sortId")
    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SAppStoreEntity that = (SAppStoreEntity) o;
        return id == that.id &&
                storeId == that.storeId &&
                wxPay == that.wxPay &&
                applePay == that.applePay &&
                aliPay == that.aliPay &&
                sortId == that.sortId &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(payWay, that.payWay) &&
                Objects.equals(appleChannelCode, that.appleChannelCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, productId, payWay, storeId, wxPay, applePay, aliPay, appleChannelCode, sortId);
    }
}
