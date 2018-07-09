package com.dszy.visualconfig.dynamic.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DictPlaceGameEntityPK implements Serializable {
    private int placeId;
    private int gameId;

    @Column(name = "placeID")
    @Id
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    @Column(name = "gameId")
    @Id
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictPlaceGameEntityPK that = (DictPlaceGameEntityPK) o;
        return placeId == that.placeId &&
                gameId == that.gameId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(placeId, gameId);
    }
}
