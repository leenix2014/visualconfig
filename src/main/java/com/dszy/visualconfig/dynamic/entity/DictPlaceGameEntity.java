package com.dszy.visualconfig.dynamic.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dict_place_game", schema = "", catalog = "")
@IdClass(DictPlaceGameEntityPK.class)
public class DictPlaceGameEntity {
    private int placeId;
    private int gameId;
    private String gameName;
    private String description;
    private Integer type;
    private Integer playType;
    private Integer initScore;
    private Integer roomFeeType;
    private Integer expiredTime;
    private Short playerSum;
    private String roundSum;
    private String isNeedRoomFee;
    private String roomFeeSum;
    private String roomFee;
    private Byte difen;
    private String wanfa;
    private String fengding;
    private String jiadi;
    private String wanfahuchi;
    private String fanma;
    private String roomShare;
    private String huahuasheng;
    private String lunhuasheng;
    private Integer voteWaitTime;
    private Integer voteCdSecond;
    private String extendColumn1;
    private String extendColumn2;
    private String extendColumn3;

    @Id
    @Column(name = "placeID")
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    @Id
    @Column(name = "gameId")
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Basic
    @Column(name = "gameName")
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "playType")
    public Integer getPlayType() {
        return playType;
    }

    public void setPlayType(Integer playType) {
        this.playType = playType;
    }

    @Basic
    @Column(name = "initScore")
    public Integer getInitScore() {
        return initScore;
    }

    public void setInitScore(Integer initScore) {
        this.initScore = initScore;
    }

    @Basic
    @Column(name = "roomFeeType")
    public Integer getRoomFeeType() {
        return roomFeeType;
    }

    public void setRoomFeeType(Integer roomFeeType) {
        this.roomFeeType = roomFeeType;
    }

    @Basic
    @Column(name = "expiredTime")
    public Integer getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Integer expiredTime) {
        this.expiredTime = expiredTime;
    }

    @Basic
    @Column(name = "playerSum")
    public Short getPlayerSum() {
        return playerSum;
    }

    public void setPlayerSum(Short playerSum) {
        this.playerSum = playerSum;
    }

    @Basic
    @Column(name = "roundSum")
    public String getRoundSum() {
        return roundSum;
    }

    public void setRoundSum(String roundSum) {
        this.roundSum = roundSum;
    }

    @Basic
    @Column(name = "isNeedRoomFee")
    public String getIsNeedRoomFee() {
        return isNeedRoomFee;
    }

    public void setIsNeedRoomFee(String isNeedRoomFee) {
        this.isNeedRoomFee = isNeedRoomFee;
    }

    @Basic
    @Column(name = "roomFeeSum")
    public String getRoomFeeSum() {
        return roomFeeSum;
    }

    public void setRoomFeeSum(String roomFeeSum) {
        this.roomFeeSum = roomFeeSum;
    }

    @Basic
    @Column(name = "roomFee")
    public String getRoomFee() {
        return roomFee;
    }

    public void setRoomFee(String roomFee) {
        this.roomFee = roomFee;
    }

    @Basic
    @Column(name = "difen")
    public Byte getDifen() {
        return difen;
    }

    public void setDifen(Byte difen) {
        this.difen = difen;
    }

    @Basic
    @Column(name = "wanfa")
    public String getWanfa() {
        return wanfa;
    }

    public void setWanfa(String wanfa) {
        this.wanfa = wanfa;
    }

    @Basic
    @Column(name = "fengding")
    public String getFengding() {
        return fengding;
    }

    public void setFengding(String fengding) {
        this.fengding = fengding;
    }

    @Basic
    @Column(name = "jiadi")
    public String getJiadi() {
        return jiadi;
    }

    public void setJiadi(String jiadi) {
        this.jiadi = jiadi;
    }

    @Basic
    @Column(name = "wanfahuchi")
    public String getWanfahuchi() {
        return wanfahuchi;
    }

    public void setWanfahuchi(String wanfahuchi) {
        this.wanfahuchi = wanfahuchi;
    }

    @Basic
    @Column(name = "fanma")
    public String getFanma() {
        return fanma;
    }

    public void setFanma(String fanma) {
        this.fanma = fanma;
    }

    @Basic
    @Column(name = "roomShare")
    public String getRoomShare() {
        return roomShare;
    }

    public void setRoomShare(String roomShare) {
        this.roomShare = roomShare;
    }

    @Basic
    @Column(name = "huahuasheng")
    public String getHuahuasheng() {
        return huahuasheng;
    }

    public void setHuahuasheng(String huahuasheng) {
        this.huahuasheng = huahuasheng;
    }

    @Basic
    @Column(name = "lunhuasheng")
    public String getLunhuasheng() {
        return lunhuasheng;
    }

    public void setLunhuasheng(String lunhuasheng) {
        this.lunhuasheng = lunhuasheng;
    }

    @Basic
    @Column(name = "voteWaitTime")
    public Integer getVoteWaitTime() {
        return voteWaitTime;
    }

    public void setVoteWaitTime(Integer voteWaitTime) {
        this.voteWaitTime = voteWaitTime;
    }

    @Basic
    @Column(name = "voteCdSecond")
    public Integer getVoteCdSecond() {
        return voteCdSecond;
    }

    public void setVoteCdSecond(Integer voteCdSecond) {
        this.voteCdSecond = voteCdSecond;
    }

    @Basic
    @Column(name = "extendColumn1")
    public String getExtendColumn1() {
        return extendColumn1;
    }

    public void setExtendColumn1(String extendColumn1) {
        this.extendColumn1 = extendColumn1;
    }

    @Basic
    @Column(name = "extendColumn2")
    public String getExtendColumn2() {
        return extendColumn2;
    }

    public void setExtendColumn2(String extendColumn2) {
        this.extendColumn2 = extendColumn2;
    }

    @Basic
    @Column(name = "extendColumn3")
    public String getExtendColumn3() {
        return extendColumn3;
    }

    public void setExtendColumn3(String extendColumn3) {
        this.extendColumn3 = extendColumn3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictPlaceGameEntity that = (DictPlaceGameEntity) o;
        return placeId == that.placeId &&
                gameId == that.gameId &&
                Objects.equals(gameName, that.gameName) &&
                Objects.equals(description, that.description) &&
                Objects.equals(type, that.type) &&
                Objects.equals(playType, that.playType) &&
                Objects.equals(initScore, that.initScore) &&
                Objects.equals(roomFeeType, that.roomFeeType) &&
                Objects.equals(expiredTime, that.expiredTime) &&
                Objects.equals(playerSum, that.playerSum) &&
                Objects.equals(roundSum, that.roundSum) &&
                Objects.equals(isNeedRoomFee, that.isNeedRoomFee) &&
                Objects.equals(roomFeeSum, that.roomFeeSum) &&
                Objects.equals(roomFee, that.roomFee) &&
                Objects.equals(difen, that.difen) &&
                Objects.equals(wanfa, that.wanfa) &&
                Objects.equals(fengding, that.fengding) &&
                Objects.equals(jiadi, that.jiadi) &&
                Objects.equals(wanfahuchi, that.wanfahuchi) &&
                Objects.equals(fanma, that.fanma) &&
                Objects.equals(roomShare, that.roomShare) &&
                Objects.equals(huahuasheng, that.huahuasheng) &&
                Objects.equals(lunhuasheng, that.lunhuasheng) &&
                Objects.equals(voteWaitTime, that.voteWaitTime) &&
                Objects.equals(voteCdSecond, that.voteCdSecond) &&
                Objects.equals(extendColumn1, that.extendColumn1) &&
                Objects.equals(extendColumn2, that.extendColumn2) &&
                Objects.equals(extendColumn3, that.extendColumn3);
    }

    @Override
    public int hashCode() {

        return Objects.hash(placeId, gameId, gameName, description, type, playType, initScore, roomFeeType, expiredTime, playerSum, roundSum, isNeedRoomFee, roomFeeSum, roomFee, difen, wanfa, fengding, jiadi, wanfahuchi, fanma, roomShare, huahuasheng, lunhuasheng, voteWaitTime, voteCdSecond, extendColumn1, extendColumn2, extendColumn3);
    }
}
