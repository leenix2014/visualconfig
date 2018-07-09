package com.dszy.visualconfig.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "dict_formal", schema = "club_dict", catalog = "")
public class DictFormalEntity {
    private Integer id;
    private Integer gameId;
    private Integer peopleNum;
    private Integer newPeopleNum;
    private BigDecimal expireDay;
    private Integer pyjRoomNum;
    private Integer nonPyjRoomNum;
    private Integer award;
    private Integer refreshDay;
    private byte isEnable;
    private Date createDate;

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
    @Column(name = "peopleNum")
    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    @Basic
    @Column(name = "newPeopleNum")
    public Integer getNewPeopleNum() {
        return newPeopleNum;
    }

    public void setNewPeopleNum(Integer newPeopleNum) {
        this.newPeopleNum = newPeopleNum;
    }

    @Basic
    @Column(name = "expireDay")
    public BigDecimal getExpireDay() {
        return expireDay;
    }

    public void setExpireDay(BigDecimal expireDay) {
        this.expireDay = expireDay;
    }

    @Basic
    @Column(name = "pyjRoomNum")
    public Integer getPyjRoomNum() {
        return pyjRoomNum;
    }

    public void setPyjRoomNum(Integer pyjRoomNum) {
        this.pyjRoomNum = pyjRoomNum;
    }

    @Basic
    @Column(name = "nonPyjRoomNum")
    public Integer getNonPyjRoomNum() {
        return nonPyjRoomNum;
    }

    public void setNonPyjRoomNum(Integer nonPyjRoomNum) {
        this.nonPyjRoomNum = nonPyjRoomNum;
    }

    @Basic
    @Column(name = "award")
    public Integer getAward() {
        return award;
    }

    public void setAward(Integer award) {
        this.award = award;
    }

    @Basic
    @Column(name = "refreshDay")
    public Integer getRefreshDay() {
        return refreshDay;
    }

    public void setRefreshDay(Integer refreshDay) {
        this.refreshDay = refreshDay;
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
    @Column(name = "createDate")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictFormalEntity that = (DictFormalEntity) o;
        return id == that.id &&
                gameId == that.gameId &&
                peopleNum == that.peopleNum &&
                newPeopleNum == that.newPeopleNum &&
                pyjRoomNum == that.pyjRoomNum &&
                nonPyjRoomNum == that.nonPyjRoomNum &&
                award == that.award &&
                refreshDay == that.refreshDay &&
                isEnable == that.isEnable &&
                Objects.equals(expireDay, that.expireDay) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, gameId, peopleNum, newPeopleNum, expireDay, pyjRoomNum, nonPyjRoomNum, award, refreshDay, isEnable, createDate);
    }
}
