package com.dszy.visualconfig.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "s_pay_config", schema = "shoppingcenter", catalog = "")
public class SPayConfigEntity {
    private String productId;
    private String productName;
    private String body;
    private String applyUrl;
    private String spBillCreateIp;
    private String wxTradeType;
    private String wxAppId;
    private String wxMchId;
    private String wxMchKey;
    private String wxCallBack;
    private String gameWebUrl;
    private String alipayUrl;
    private String alipayback;
    private String aliPayAppId;
    private String aliPayPublickey;
    private String aliPayPrivatekey;

    @Id
    @Column(name = "productId")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "productName")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "body")
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Basic
    @Column(name = "applyURL")
    public String getApplyUrl() {
        return applyUrl;
    }

    public void setApplyUrl(String applyUrl) {
        this.applyUrl = applyUrl;
    }

    @Basic
    @Column(name = "spBillCreateIP")
    public String getSpBillCreateIp() {
        return spBillCreateIp;
    }

    public void setSpBillCreateIp(String spBillCreateIp) {
        this.spBillCreateIp = spBillCreateIp;
    }

    @Basic
    @Column(name = "wxTradeType")
    public String getWxTradeType() {
        return wxTradeType;
    }

    public void setWxTradeType(String wxTradeType) {
        this.wxTradeType = wxTradeType;
    }

    @Basic
    @Column(name = "wxAPPId")
    public String getWxAppId() {
        return wxAppId;
    }

    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }

    @Basic
    @Column(name = "wxMchId")
    public String getWxMchId() {
        return wxMchId;
    }

    public void setWxMchId(String wxMchId) {
        this.wxMchId = wxMchId;
    }

    @Basic
    @Column(name = "wxMchKey")
    public String getWxMchKey() {
        return wxMchKey;
    }

    public void setWxMchKey(String wxMchKey) {
        this.wxMchKey = wxMchKey;
    }

    @Basic
    @Column(name = "wxCallBack")
    public String getWxCallBack() {
        return wxCallBack;
    }

    public void setWxCallBack(String wxCallBack) {
        this.wxCallBack = wxCallBack;
    }

    @Basic
    @Column(name = "gameWebURL")
    public String getGameWebUrl() {
        return gameWebUrl;
    }

    public void setGameWebUrl(String gameWebUrl) {
        this.gameWebUrl = gameWebUrl;
    }

    @Basic
    @Column(name = "alipayURL")
    public String getAlipayUrl() {
        return alipayUrl;
    }

    public void setAlipayUrl(String alipayUrl) {
        this.alipayUrl = alipayUrl;
    }

    @Basic
    @Column(name = "alipayback")
    public String getAlipayback() {
        return alipayback;
    }

    public void setAlipayback(String alipayback) {
        this.alipayback = alipayback;
    }

    @Basic
    @Column(name = "aliPayAPPId")
    public String getAliPayAppId() {
        return aliPayAppId;
    }

    public void setAliPayAppId(String aliPayAppId) {
        this.aliPayAppId = aliPayAppId;
    }

    @Basic
    @Column(name = "aliPayPublickey")
    public String getAliPayPublickey() {
        return aliPayPublickey;
    }

    public void setAliPayPublickey(String aliPayPublickey) {
        this.aliPayPublickey = aliPayPublickey;
    }

    @Basic
    @Column(name = "aliPayPrivatekey")
    public String getAliPayPrivatekey() {
        return aliPayPrivatekey;
    }

    public void setAliPayPrivatekey(String aliPayPrivatekey) {
        this.aliPayPrivatekey = aliPayPrivatekey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SPayConfigEntity that = (SPayConfigEntity) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(body, that.body) &&
                Objects.equals(applyUrl, that.applyUrl) &&
                Objects.equals(spBillCreateIp, that.spBillCreateIp) &&
                Objects.equals(wxTradeType, that.wxTradeType) &&
                Objects.equals(wxAppId, that.wxAppId) &&
                Objects.equals(wxMchId, that.wxMchId) &&
                Objects.equals(wxMchKey, that.wxMchKey) &&
                Objects.equals(wxCallBack, that.wxCallBack) &&
                Objects.equals(gameWebUrl, that.gameWebUrl) &&
                Objects.equals(alipayUrl, that.alipayUrl) &&
                Objects.equals(alipayback, that.alipayback) &&
                Objects.equals(aliPayAppId, that.aliPayAppId) &&
                Objects.equals(aliPayPublickey, that.aliPayPublickey) &&
                Objects.equals(aliPayPrivatekey, that.aliPayPrivatekey);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productId, productName, body, applyUrl, spBillCreateIp, wxTradeType, wxAppId, wxMchId, wxMchKey, wxCallBack, gameWebUrl, alipayUrl, alipayback, aliPayAppId, aliPayPublickey, aliPayPrivatekey);
    }
}
