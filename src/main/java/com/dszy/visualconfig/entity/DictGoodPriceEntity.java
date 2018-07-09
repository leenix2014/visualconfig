package com.dszy.visualconfig.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "dict_good_price", schema = "club_dict", catalog = "")
public class DictGoodPriceEntity {
    private Integer id;
    private Integer gameId;
    private String goodName;
    private BigDecimal cashPrice;
    private BigDecimal nonCashDiscount;
    private Integer goodNum;
    private Integer giftNum;
    private byte type;
    private byte isEnable;
    private String remark;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "gameId")
    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    @Basic
    @Column(name = "goodName")
    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    @Basic
    @Column(name = "cashPrice")
    public BigDecimal getCashPrice() {
        return cashPrice;
    }

    public void setCashPrice(BigDecimal cashPrice) {
        this.cashPrice = cashPrice;
    }

    @Basic
    @Column(name = "nonCashDiscount")
    public BigDecimal getNonCashDiscount() {
        return nonCashDiscount;
    }

    public void setNonCashDiscount(BigDecimal nonCashDiscount) {
        this.nonCashDiscount = nonCashDiscount;
    }

    @Basic
    @Column(name = "goodNum")
    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    @Basic
    @Column(name = "giftNum")
    public Integer getGiftNum() {
        return giftNum;
    }

    public void setGiftNum(Integer giftNum) {
        this.giftNum = giftNum;
    }

    @Basic
    @Column(name = "type")
    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    @Basic
    @Column(name = "isEnable")
    public byte getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(byte isEnable) {
        this.isEnable = isEnable;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictGoodPriceEntity that = (DictGoodPriceEntity) o;
        return id == that.id &&
                gameId == that.gameId &&
                goodNum == that.goodNum &&
                giftNum == that.giftNum &&
                type == that.type &&
                isEnable == that.isEnable &&
                Objects.equals(goodName, that.goodName) &&
                Objects.equals(cashPrice, that.cashPrice) &&
                Objects.equals(nonCashDiscount, that.nonCashDiscount) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, gameId, goodName, cashPrice, nonCashDiscount, goodNum, giftNum, type, isEnable, remark);
    }
}
