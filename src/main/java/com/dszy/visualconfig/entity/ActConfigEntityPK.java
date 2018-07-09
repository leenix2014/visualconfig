package com.dszy.visualconfig.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ActConfigEntityPK implements Serializable {
    private int gameId;
    private String sKey;

    @Column(name = "gameId")
    @Id
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Column(name = "sKey")
    @Id
    public String getsKey() {
        return sKey;
    }

    public void setsKey(String sKey) {
        this.sKey = sKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActConfigEntityPK that = (ActConfigEntityPK) o;
        return gameId == that.gameId &&
                Objects.equals(sKey, that.sKey);
    }

    @Override
    public int hashCode() {

        return Objects.hash(gameId, sKey);
    }
}
