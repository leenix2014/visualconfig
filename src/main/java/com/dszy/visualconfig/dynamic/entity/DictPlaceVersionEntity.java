package com.dszy.visualconfig.dynamic.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dict_place_version", schema = "", catalog = "")
public class DictPlaceVersionEntity {
    private int firstId;
    private String version;
    private String reviewVersion;

    @Id
    @Column(name = "firstID")
    public int getFirstId() {
        return firstId;
    }

    public void setFirstId(int firstId) {
        this.firstId = firstId;
    }

    @Basic
    @Column(name = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Basic
    @Column(name = "reviewVersion")
    public String getReviewVersion() {
        return reviewVersion;
    }

    public void setReviewVersion(String reviewVersion) {
        this.reviewVersion = reviewVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictPlaceVersionEntity that = (DictPlaceVersionEntity) o;
        return firstId == that.firstId &&
                Objects.equals(version, that.version) &&
                Objects.equals(reviewVersion, that.reviewVersion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstId, version, reviewVersion);
    }
}
