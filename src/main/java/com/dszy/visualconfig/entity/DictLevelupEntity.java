package com.dszy.visualconfig.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "dict_levelup", schema = "club_dict", catalog = "")
public class DictLevelupEntity {
    private Integer id;
    private Integer gameId;
    private Integer levelUpType;
    private BigDecimal totalPay;
    private Integer totalPromoter;
    private byte isEnable;

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
    @Column(name = "levelUpType")
    public Integer getLevelUpType() {
        return levelUpType;
    }

    public void setLevelUpType(Integer levelUpType) {
        this.levelUpType = levelUpType;
    }

    @Basic
    @Column(name = "totalPay")
    public BigDecimal getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(BigDecimal totalPay) {
        this.totalPay = totalPay;
    }

    @Basic
    @Column(name = "totalPromoter")
    public Integer getTotalPromoter() {
        return totalPromoter;
    }

    public void setTotalPromoter(Integer totalPromoter) {
        this.totalPromoter = totalPromoter;
    }

    @Basic
    @Column(name = "isEnable")
    public byte getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(byte isEnable) {
        this.isEnable = isEnable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictLevelupEntity that = (DictLevelupEntity) o;
        return id == that.id &&
                gameId == that.gameId &&
                levelUpType == that.levelUpType &&
                totalPromoter == that.totalPromoter &&
                isEnable == that.isEnable &&
                Objects.equals(totalPay, that.totalPay);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, gameId, levelUpType, totalPay, totalPromoter, isEnable);
    }
}
