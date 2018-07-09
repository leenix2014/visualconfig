package com.dszy.visualconfig.dynamic.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dict_place_config", schema = "", catalog = "")
public class DictPlaceConfigEntity {
    private int placeId;
    private String pyjRechargeTips;
    private String pyjAdvertisementUrLs;
    private String recruitSetting;
    private String popupAdUrLs;
    private int popupAdEnable;
    private String marqueenTipMap;
    private String dailyShare;
    private String inviteShare;
    private String clubShare;

    @Id
    @Column(name = "placeID")
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    @Basic
    @Column(name = "pyjRechargeTips")
    public String getPyjRechargeTips() {
        return pyjRechargeTips;
    }

    public void setPyjRechargeTips(String pyjRechargeTips) {
        this.pyjRechargeTips = pyjRechargeTips;
    }

    @Basic
    @Column(name = "pyjAdvertisementURLs")
    public String getPyjAdvertisementUrLs() {
        return pyjAdvertisementUrLs;
    }

    public void setPyjAdvertisementUrLs(String pyjAdvertisementUrLs) {
        this.pyjAdvertisementUrLs = pyjAdvertisementUrLs;
    }

    @Basic
    @Column(name = "recruitSetting")
    public String getRecruitSetting() {
        return recruitSetting;
    }

    public void setRecruitSetting(String recruitSetting) {
        this.recruitSetting = recruitSetting;
    }

    @Basic
    @Column(name = "popupAdURLs")
    public String getPopupAdUrLs() {
        return popupAdUrLs;
    }

    public void setPopupAdUrLs(String popupAdUrLs) {
        this.popupAdUrLs = popupAdUrLs;
    }

    @Basic
    @Column(name = "popupAdEnable")
    public int getPopupAdEnable() {
        return popupAdEnable;
    }

    public void setPopupAdEnable(int popupAdEnable) {
        this.popupAdEnable = popupAdEnable;
    }

    @Basic
    @Column(name = "marqueenTipMap")
    public String getMarqueenTipMap() {
        return marqueenTipMap;
    }

    public void setMarqueenTipMap(String marqueenTipMap) {
        this.marqueenTipMap = marqueenTipMap;
    }

    @Basic
    @Column(name = "dailyShare")
    public String getDailyShare() {
        return dailyShare;
    }

    public void setDailyShare(String dailyShare) {
        this.dailyShare = dailyShare;
    }

    @Basic
    @Column(name = "inviteShare")
    public String getInviteShare() {
        return inviteShare;
    }

    public void setInviteShare(String inviteShare) {
        this.inviteShare = inviteShare;
    }

    @Basic
    @Column(name = "clubShare")
    public String getClubShare() {
        return clubShare;
    }

    public void setClubShare(String clubShare) {
        this.clubShare = clubShare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictPlaceConfigEntity that = (DictPlaceConfigEntity) o;
        return placeId == that.placeId &&
                popupAdEnable == that.popupAdEnable &&
                Objects.equals(pyjRechargeTips, that.pyjRechargeTips) &&
                Objects.equals(pyjAdvertisementUrLs, that.pyjAdvertisementUrLs) &&
                Objects.equals(recruitSetting, that.recruitSetting) &&
                Objects.equals(popupAdUrLs, that.popupAdUrLs) &&
                Objects.equals(marqueenTipMap, that.marqueenTipMap) &&
                Objects.equals(dailyShare, that.dailyShare) &&
                Objects.equals(inviteShare, that.inviteShare) &&
                Objects.equals(clubShare, that.clubShare);
    }

    @Override
    public int hashCode() {

        return Objects.hash(placeId, pyjRechargeTips, pyjAdvertisementUrLs, recruitSetting, popupAdUrLs, popupAdEnable, marqueenTipMap, dailyShare, inviteShare, clubShare);
    }
}
