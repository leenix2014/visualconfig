package com.dszy.visualconfig.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dict_game_db", schema = "club_dict", catalog = "")
public class DictGameDbEntity {
    private Integer id;
    private Integer gameId;
    private String dbNamePrefix;
    private String dbUrl;
    private String dbUser;
    private String dbPass;
    private String dbUrlRead;
    private String dbUserRead;
    private String dbPassRead;
    private String webDomain;
    private Integer webPort;
    private Integer itemId;
    private byte isEnable;

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
    @Column(name = "dbNamePrefix")
    public String getDbNamePrefix() {
        return dbNamePrefix;
    }

    public void setDbNamePrefix(String dbNamePrefix) {
        this.dbNamePrefix = dbNamePrefix;
    }

    @Basic
    @Column(name = "dbUrl")
    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    @Basic
    @Column(name = "dbUser")
    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    @Basic
    @Column(name = "dbPass")
    public String getDbPass() {
        return dbPass;
    }

    public void setDbPass(String dbPass) {
        this.dbPass = dbPass;
    }

    @Basic
    @Column(name = "dbUrlRead")
    public String getDbUrlRead() {
        return dbUrlRead;
    }

    public void setDbUrlRead(String dbUrlRead) {
        this.dbUrlRead = dbUrlRead;
    }

    @Basic
    @Column(name = "dbUserRead")
    public String getDbUserRead() {
        return dbUserRead;
    }

    public void setDbUserRead(String dbUserRead) {
        this.dbUserRead = dbUserRead;
    }

    @Basic
    @Column(name = "dbPassRead")
    public String getDbPassRead() {
        return dbPassRead;
    }

    public void setDbPassRead(String dbPassRead) {
        this.dbPassRead = dbPassRead;
    }

    @Basic
    @Column(name = "webDomain")
    public String getWebDomain() {
        return webDomain;
    }

    public void setWebDomain(String webDomain) {
        this.webDomain = webDomain;
    }

    @Basic
    @Column(name = "webPort")
    public Integer getWebPort() {
        return webPort;
    }

    public void setWebPort(Integer webPort) {
        this.webPort = webPort;
    }

    @Basic
    @Column(name = "itemId")
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "isEnable")
    public byte getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(byte isEnable) {
        this.isEnable = isEnable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictGameDbEntity that = (DictGameDbEntity) o;
        return id == that.id &&
                gameId == that.gameId &&
                webPort == that.webPort &&
                itemId == that.itemId &&
                isEnable == that.isEnable &&
                Objects.equals(dbNamePrefix, that.dbNamePrefix) &&
                Objects.equals(dbUrl, that.dbUrl) &&
                Objects.equals(dbUser, that.dbUser) &&
                Objects.equals(dbPass, that.dbPass) &&
                Objects.equals(dbUrlRead, that.dbUrlRead) &&
                Objects.equals(dbUserRead, that.dbUserRead) &&
                Objects.equals(dbPassRead, that.dbPassRead) &&
                Objects.equals(webDomain, that.webDomain);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, gameId, dbNamePrefix, dbUrl, dbUser, dbPass, dbUrlRead, dbUserRead, dbPassRead, webDomain, webPort, itemId, isEnable);
    }
}
