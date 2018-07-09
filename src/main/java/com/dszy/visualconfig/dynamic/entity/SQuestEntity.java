package com.dszy.visualconfig.dynamic.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "s_quest", schema = "", catalog = "")
@IdClass(SQuestEntityPK.class)
public class SQuestEntity {
    private int id;
    private Integer type;
    private String questName;
    private Short questType;
    private Integer preQuestId;
    private Integer repeatSum;
    private Integer condition1;
    private Integer condition2;
    private Integer condition3;
    private Byte awardAutoSend;
    private Byte awardType;
    private String awardList;
    private String desc;
    private Long iconImg;
    private Byte recommend;
    private Byte showQustList;
    private String distCode;
    private Integer acceptType;
    private Integer acceptValue;
    private Byte shareTag;
    private String shareAward;
    private String shareTitle;
    private String shareDesc;
    private String shareLink;
    private Integer order;
    private Integer citycode;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "questName")
    public String getQuestName() {
        return questName;
    }

    public void setQuestName(String questName) {
        this.questName = questName;
    }

    @Basic
    @Column(name = "questType")
    public Short getQuestType() {
        return questType;
    }

    public void setQuestType(Short questType) {
        this.questType = questType;
    }

    @Basic
    @Column(name = "preQuestId")
    public Integer getPreQuestId() {
        return preQuestId;
    }

    public void setPreQuestId(Integer preQuestId) {
        this.preQuestId = preQuestId;
    }

    @Basic
    @Column(name = "repeatSum")
    public Integer getRepeatSum() {
        return repeatSum;
    }

    public void setRepeatSum(Integer repeatSum) {
        this.repeatSum = repeatSum;
    }

    @Basic
    @Column(name = "condition1")
    public Integer getCondition1() {
        return condition1;
    }

    public void setCondition1(Integer condition1) {
        this.condition1 = condition1;
    }

    @Basic
    @Column(name = "condition2")
    public Integer getCondition2() {
        return condition2;
    }

    public void setCondition2(Integer condition2) {
        this.condition2 = condition2;
    }

    @Basic
    @Column(name = "condition3")
    public Integer getCondition3() {
        return condition3;
    }

    public void setCondition3(Integer condition3) {
        this.condition3 = condition3;
    }

    @Basic
    @Column(name = "awardAutoSend")
    public Byte getAwardAutoSend() {
        return awardAutoSend;
    }

    public void setAwardAutoSend(Byte awardAutoSend) {
        this.awardAutoSend = awardAutoSend;
    }

    @Basic
    @Column(name = "awardType")
    public Byte getAwardType() {
        return awardType;
    }

    public void setAwardType(Byte awardType) {
        this.awardType = awardType;
    }

    @Basic
    @Column(name = "awardList")
    public String getAwardList() {
        return awardList;
    }

    public void setAwardList(String awardList) {
        this.awardList = awardList;
    }

    @Id
    @Column(name = "desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "iconImg")
    public Long getIconImg() {
        return iconImg;
    }

    public void setIconImg(Long iconImg) {
        this.iconImg = iconImg;
    }

    @Basic
    @Column(name = "recommend")
    public Byte getRecommend() {
        return recommend;
    }

    public void setRecommend(Byte recommend) {
        this.recommend = recommend;
    }

    @Basic
    @Column(name = "showQustList")
    public Byte getShowQustList() {
        return showQustList;
    }

    public void setShowQustList(Byte showQustList) {
        this.showQustList = showQustList;
    }

    @Basic
    @Column(name = "distCode")
    public String getDistCode() {
        return distCode;
    }

    public void setDistCode(String distCode) {
        this.distCode = distCode;
    }

    @Basic
    @Column(name = "acceptType")
    public Integer getAcceptType() {
        return acceptType;
    }

    public void setAcceptType(Integer acceptType) {
        this.acceptType = acceptType;
    }

    @Basic
    @Column(name = "acceptValue")
    public Integer getAcceptValue() {
        return acceptValue;
    }

    public void setAcceptValue(Integer acceptValue) {
        this.acceptValue = acceptValue;
    }

    @Basic
    @Column(name = "shareTag")
    public Byte getShareTag() {
        return shareTag;
    }

    public void setShareTag(Byte shareTag) {
        this.shareTag = shareTag;
    }

    @Basic
    @Column(name = "shareAward")
    public String getShareAward() {
        return shareAward;
    }

    public void setShareAward(String shareAward) {
        this.shareAward = shareAward;
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
    @Column(name = "shareLink")
    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    @Basic
    @Column(name = "order")
    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Basic
    @Column(name = "citycode")
    public Integer getCitycode() {
        return citycode;
    }

    public void setCitycode(Integer citycode) {
        this.citycode = citycode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SQuestEntity that = (SQuestEntity) o;
        return id == that.id &&
                Objects.equals(type, that.type) &&
                Objects.equals(questName, that.questName) &&
                Objects.equals(questType, that.questType) &&
                Objects.equals(preQuestId, that.preQuestId) &&
                Objects.equals(repeatSum, that.repeatSum) &&
                Objects.equals(condition1, that.condition1) &&
                Objects.equals(condition2, that.condition2) &&
                Objects.equals(condition3, that.condition3) &&
                Objects.equals(awardAutoSend, that.awardAutoSend) &&
                Objects.equals(awardType, that.awardType) &&
                Objects.equals(awardList, that.awardList) &&
                Objects.equals(desc, that.desc) &&
                Objects.equals(iconImg, that.iconImg) &&
                Objects.equals(recommend, that.recommend) &&
                Objects.equals(showQustList, that.showQustList) &&
                Objects.equals(distCode, that.distCode) &&
                Objects.equals(acceptType, that.acceptType) &&
                Objects.equals(acceptValue, that.acceptValue) &&
                Objects.equals(shareTag, that.shareTag) &&
                Objects.equals(shareAward, that.shareAward) &&
                Objects.equals(shareTitle, that.shareTitle) &&
                Objects.equals(shareDesc, that.shareDesc) &&
                Objects.equals(shareLink, that.shareLink) &&
                Objects.equals(order, that.order) &&
                Objects.equals(citycode, that.citycode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, type, questName, questType, preQuestId, repeatSum, condition1, condition2, condition3, awardAutoSend, awardType, awardList, desc, iconImg, recommend, showQustList, distCode, acceptType, acceptValue, shareTag, shareAward, shareTitle, shareDesc, shareLink, order, citycode);
    }
}
