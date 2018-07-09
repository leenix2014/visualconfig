package com.dszy.visualconfig.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sad_game", schema = "sadmin_test", catalog = "")
public class SadGameEntity {
    private Integer id;
    private Integer gameId;
    private String gameName;
    private byte gameStatus;
    private String iosPackageName;
    private String androidPackageName;
    private String apiIp;
    private Integer apiPort;
    private String activityApi;
    private Integer activityApiPort;
    private String resourceIp;
    private Integer resourcePort;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    @Column(name = "game_name")
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    @Basic
    @Column(name = "game_status")
    public byte getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(byte gameStatus) {
        this.gameStatus = gameStatus;
    }

    @Basic
    @Column(name = "ios_package_name")
    public String getIosPackageName() {
        return iosPackageName;
    }

    public void setIosPackageName(String iosPackageName) {
        this.iosPackageName = iosPackageName;
    }

    @Basic
    @Column(name = "android_package_name")
    public String getAndroidPackageName() {
        return androidPackageName;
    }

    public void setAndroidPackageName(String androidPackageName) {
        this.androidPackageName = androidPackageName;
    }

    @Basic
    @Column(name = "api_ip")
    public String getApiIp() {
        return apiIp;
    }

    public void setApiIp(String apiIp) {
        this.apiIp = apiIp;
    }

    @Basic
    @Column(name = "api_port")
    public Integer getApiPort() {
        return apiPort;
    }

    public void setApiPort(Integer apiPort) {
        this.apiPort = apiPort;
    }

    @Basic
    @Column(name = "activity_api")
    public String getActivityApi() {
        return activityApi;
    }

    public void setActivityApi(String activityApi) {
        this.activityApi = activityApi;
    }

    @Basic
    @Column(name = "activity_api_port")
    public Integer getActivityApiPort() {
        return activityApiPort;
    }

    public void setActivityApiPort(Integer activityApiPort) {
        this.activityApiPort = activityApiPort;
    }

    @Basic
    @Column(name = "resource_ip")
    public String getResourceIp() {
        return resourceIp;
    }

    public void setResourceIp(String resourceIp) {
        this.resourceIp = resourceIp;
    }

    @Basic
    @Column(name = "resource_port")
    public Integer getResourcePort() {
        return resourcePort;
    }

    public void setResourcePort(Integer resourcePort) {
        this.resourcePort = resourcePort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SadGameEntity that = (SadGameEntity) o;
        return id == that.id &&
                gameId == that.gameId &&
                gameStatus == that.gameStatus &&
                apiPort == that.apiPort &&
                activityApiPort == that.activityApiPort &&
                resourcePort == that.resourcePort &&
                Objects.equals(gameName, that.gameName) &&
                Objects.equals(iosPackageName, that.iosPackageName) &&
                Objects.equals(androidPackageName, that.androidPackageName) &&
                Objects.equals(apiIp, that.apiIp) &&
                Objects.equals(activityApi, that.activityApi) &&
                Objects.equals(resourceIp, that.resourceIp);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, gameId, gameName, gameStatus, iosPackageName, androidPackageName, apiIp, apiPort, activityApi, activityApiPort, resourceIp, resourcePort);
    }
}
