package com.dszy.visualconfig.dynamic.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DictConfigEntityPK implements Serializable {
    private int productId;
    private String sKey;

    @Column(name = "productId")
    @Id
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
        DictConfigEntityPK that = (DictConfigEntityPK) o;
        return productId == that.productId &&
                Objects.equals(sKey, that.sKey);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productId, sKey);
    }
}
