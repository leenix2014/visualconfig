package com.dszy.visualconfig.dynamic.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "dict_activity", schema = "", catalog = "")
public class DictActivityEntity {
    private int id;
    private String user;
    private int gameId;
    private String title;
    private int ui;
    private int contentType;
    private String content;
    private String url;
    private int type;
    private String share;
    private int status;
    private Timestamp startTime;
    private Timestamp endTime;
    private Timestamp vanishTime;
    private Integer flag;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Basic
    @Column(name = "gameId")
    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "ui")
    public int getUi() {
        return ui;
    }

    public void setUi(int ui) {
        this.ui = ui;
    }

    @Basic
    @Column(name = "contentType")
    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "share")
    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "startTime")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "endTime")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "vanishTime")
    public Timestamp getVanishTime() {
        return vanishTime;
    }

    public void setVanishTime(Timestamp vanishTime) {
        this.vanishTime = vanishTime;
    }

    @Basic
    @Column(name = "flag")
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictActivityEntity that = (DictActivityEntity) o;
        return id == that.id &&
                gameId == that.gameId &&
                ui == that.ui &&
                contentType == that.contentType &&
                type == that.type &&
                status == that.status &&
                Objects.equals(user, that.user) &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(url, that.url) &&
                Objects.equals(share, that.share) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(vanishTime, that.vanishTime) &&
                Objects.equals(flag, that.flag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, user, gameId, title, ui, contentType, content, url, type, share, status, startTime, endTime, vanishTime, flag);
    }
}
