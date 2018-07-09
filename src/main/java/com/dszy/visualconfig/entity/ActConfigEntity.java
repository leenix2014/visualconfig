package com.dszy.visualconfig.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "act_config", schema = "dsqp_activity", catalog = "")
@IdClass(ActConfigEntityPK.class)
public class ActConfigEntity {
    private int gameId;
    private String sKey;
    private String sValue;
    private String sDesc;

    @Id
    @Column(name = "gameId")
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Id
    @Column(name = "sKey")
    public String getsKey() {
        return sKey;
    }

    public void setsKey(String sKey) {
        this.sKey = sKey;
    }

    @Basic
    @Column(name = "sValue")
    public String getsValue() {
        return sValue;
    }

    public void setsValue(String sValue) {
        this.sValue = sValue;
    }

    @Basic
    @Column(name = "sDesc")
    public String getsDesc() {
        return sDesc;
    }

    public void setsDesc(String sDesc) {
        this.sDesc = sDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActConfigEntity that = (ActConfigEntity) o;
        return gameId == that.gameId &&
                Objects.equals(sKey, that.sKey) &&
                Objects.equals(sValue, that.sValue) &&
                Objects.equals(sDesc, that.sDesc);
    }

    @Override
    public int hashCode() {

        return Objects.hash(gameId, sKey, sValue, sDesc);
    }
}
