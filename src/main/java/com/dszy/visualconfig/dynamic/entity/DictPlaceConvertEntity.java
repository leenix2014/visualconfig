package com.dszy.visualconfig.dynamic.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "dict_place_convert", schema = "", catalog = "")
public class DictPlaceConvertEntity {
    private int firstId;
    private int oldPlaceId;
    private int newPlaceId;

    @Basic
    @Column(name = "firstID")
    public int getFirstId() {
        return firstId;
    }

    public void setFirstId(int firstId) {
        this.firstId = firstId;
    }

    @Basic
    @Column(name = "oldPlaceID")
    public int getOldPlaceId() {
        return oldPlaceId;
    }

    public void setOldPlaceId(int oldPlaceId) {
        this.oldPlaceId = oldPlaceId;
    }

    @Basic
    @Column(name = "newPlaceID")
    public int getNewPlaceId() {
        return newPlaceId;
    }

    public void setNewPlaceId(int newPlaceId) {
        this.newPlaceId = newPlaceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictPlaceConvertEntity that = (DictPlaceConvertEntity) o;
        return firstId == that.firstId &&
                oldPlaceId == that.oldPlaceId &&
                newPlaceId == that.newPlaceId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstId, oldPlaceId, newPlaceId);
    }
}
