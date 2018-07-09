package com.dszy.visualconfig.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "act_mall", schema = "dsqp_activity", catalog = "")
public class ActMallEntity {
    private int id;
    private Integer gameId;
    private String name;
    private Integer type;
    private String item;
    private String price;
    private Integer ui;
    private String image;
    private Integer isHot;
    private Integer status;
    private Integer amount;
    private Integer total;
    private Integer limitType;
    private Integer limitNum;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "item")
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Basic
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "ui")
    public Integer getUi() {
        return ui;
    }

    public void setUi(Integer ui) {
        this.ui = ui;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "isHot")
    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "amount")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "total")
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Basic
    @Column(name = "limitType")
    public Integer getLimitType() {
        return limitType;
    }

    public void setLimitType(Integer limitType) {
        this.limitType = limitType;
    }

    @Basic
    @Column(name = "limitNum")
    public Integer getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActMallEntity that = (ActMallEntity) o;
        return id == that.id &&
                Objects.equals(gameId, that.gameId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(item, that.item) &&
                Objects.equals(price, that.price) &&
                Objects.equals(ui, that.ui) &&
                Objects.equals(image, that.image) &&
                Objects.equals(isHot, that.isHot) &&
                Objects.equals(status, that.status) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(total, that.total) &&
                Objects.equals(limitType, that.limitType) &&
                Objects.equals(limitNum, that.limitNum);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, gameId, name, type, item, price, ui, image, isHot, status, amount, total, limitType, limitNum);
    }
}
