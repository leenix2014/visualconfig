package com.dszy.visualconfig.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "dict_share", schema = "club_dict", catalog = "")
public class DictShareEntity {
    private Integer id;
    private Integer gameId;
    private String shareIcon;
    private String shareTitle;
    private String shareDesc;
    private Timestamp createTime;
    private String shareImages;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    @Column(name = "shareIcon")
    public String getShareIcon() {
        return shareIcon;
    }

    public void setShareIcon(String shareIcon) {
        this.shareIcon = shareIcon;
    }

    @Basic
    @Column(name = "shareTitle")
    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    @Basic
    @Column(name = "shareDesc")
    public String getShareDesc() {
        return shareDesc;
    }

    public void setShareDesc(String shareDesc) {
        this.shareDesc = shareDesc;
    }

    @Basic
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "shareImages")
    public String getShareImages() {
        return shareImages;
    }

    public void setShareImages(String shareImages) {
        this.shareImages = shareImages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictShareEntity that = (DictShareEntity) o;
        return id == that.id &&
                gameId == that.gameId &&
                Objects.equals(shareIcon, that.shareIcon) &&
                Objects.equals(shareTitle, that.shareTitle) &&
                Objects.equals(shareDesc, that.shareDesc) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(shareImages, that.shareImages);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, gameId, shareIcon, shareTitle, shareDesc, createTime, shareImages);
    }
}
