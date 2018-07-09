package com.dszy.visualconfig.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sad_databases_conf", schema = "sadmin_test", catalog = "")
public class SadDatabasesConfEntity {
    private Integer id;
    private byte dbType;
    private Integer gameId;
    private String host;
    private String port;
    private String user;
    private String pwd;
    private String dbName;
    private String charset;
    private byte isMaster;
    private String remark;
    private Integer createTime;
    private Integer updateTime;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "db_type")
    public byte getDbType() {
        return dbType;
    }

    public void setDbType(byte dbType) {
        this.dbType = dbType;
    }

    @Basic
    @Column(name = "game_id")
    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    @Basic
    @Column(name = "host")
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Basic
    @Column(name = "port")
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
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
    @Column(name = "pwd")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "db_name")
    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    @Basic
    @Column(name = "charset")
    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    @Basic
    @Column(name = "is_master")
    public byte getIsMaster() {
        return isMaster;
    }

    public void setIsMaster(byte isMaster) {
        this.isMaster = isMaster;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "create_time")
    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SadDatabasesConfEntity that = (SadDatabasesConfEntity) o;
        return id == that.id &&
                dbType == that.dbType &&
                gameId == that.gameId &&
                isMaster == that.isMaster &&
                createTime == that.createTime &&
                updateTime == that.updateTime &&
                Objects.equals(host, that.host) &&
                Objects.equals(port, that.port) &&
                Objects.equals(user, that.user) &&
                Objects.equals(pwd, that.pwd) &&
                Objects.equals(dbName, that.dbName) &&
                Objects.equals(charset, that.charset) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, dbType, gameId, host, port, user, pwd, dbName, charset, isMaster, remark, createTime, updateTime);
    }
}
