package com.dszy.visualconfig.dynamic.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dict_config", schema = "", catalog = "")
@IdClass(DictConfigEntityPK.class)
public class DictConfigEntity {
    private int productId;
    private String sKey;
    private String sValue;
    private String sDesc;
    private Integer isValid;

    @Id
    @Column(name = "productId")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    @Basic
    @Column(name = "isValid")
    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictConfigEntity that = (DictConfigEntity) o;
        return productId == that.productId &&
                Objects.equals(sKey, that.sKey) &&
                Objects.equals(sValue, that.sValue) &&
                Objects.equals(sDesc, that.sDesc) &&
                Objects.equals(isValid, that.isValid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productId, sKey, sValue, sDesc, isValid);
    }
}
