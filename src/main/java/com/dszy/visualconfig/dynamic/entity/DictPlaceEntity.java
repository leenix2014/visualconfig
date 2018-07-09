package com.dszy.visualconfig.dynamic.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dict_place", schema = "", catalog = "")
public class DictPlaceEntity {
    private int placeId;
    private Integer firstId;
    private String placeName;
    private Integer placeLevel;
    private Integer parentPlaceId;
    private Integer ui;

    @Id
    @Column(name = "placeID")
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    @Basic
    @Column(name = "firstID")
    public Integer getFirstId() {
        return firstId;
    }

    public void setFirstId(Integer firstId) {
        this.firstId = firstId;
    }

    @Basic
    @Column(name = "placeName")
    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @Basic
    @Column(name = "placeLevel")
    public Integer getPlaceLevel() {
        return placeLevel;
    }

    public void setPlaceLevel(Integer placeLevel) {
        this.placeLevel = placeLevel;
    }

    @Basic
    @Column(name = "parentPlaceID")
    public Integer getParentPlaceId() {
        return parentPlaceId;
    }

    public void setParentPlaceId(Integer parentPlaceId) {
        this.parentPlaceId = parentPlaceId;
    }

    @Basic
    @Column(name = "ui")
    public Integer getUi() {
        return ui;
    }

    public void setUi(Integer ui) {
        this.ui = ui;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictPlaceEntity that = (DictPlaceEntity) o;
        return placeId == that.placeId &&
                Objects.equals(firstId, that.firstId) &&
                Objects.equals(placeName, that.placeName) &&
                Objects.equals(placeLevel, that.placeLevel) &&
                Objects.equals(parentPlaceId, that.parentPlaceId) &&
                Objects.equals(ui, that.ui);
    }

    @Override
    public int hashCode() {

        return Objects.hash(placeId, firstId, placeName, placeLevel, parentPlaceId, ui);
    }
}
