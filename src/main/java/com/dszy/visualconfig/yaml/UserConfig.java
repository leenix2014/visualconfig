package com.dszy.visualconfig.yaml;

public class UserConfig {

	private String version = "";

	private String checkVersionList = "";

	// 消息是否加密校验
	private boolean checkFlag = false;

	// 计费二次确认
	private boolean rechargeComfirmSwitch = false;

	// 新手注册赠送
	private int newBeeCash = 3000;

	// 默认城市
	private int defaultCity = 0;

	// 单局最大输钱
	private int playLostCashLimit = 0;

	// 单局最大赢钱
	private int playWinCashLimit = 0;

	// 单场最大输钱
	private int roomLostCashLimit = 0;

	// 单场最大赢钱
	private int roomWinCashLimit = 0;

	// 单日最大输钱
	private int dayLostCashLimit = 0;

	// 单日最大赢钱
	private int dayWinCashLimit = 0;

	private boolean cashLimitOpen;

	private int smsTimeout = 5 * 60;

	private boolean testBilling;
	/** 新注册玩家开房卡 **/
	private long privateRoomDiamond;

	/****
	 * 测试新版本号名单
	 * 
	 * @param userId
	 * @return
	 */
	public boolean checkVersionInList(long userId) {
		if (checkVersionList == null || checkVersionList.equals("all")) {
			return false;
		} else {
			String[] ids = checkVersionList.split(",");
			for (String id : ids) {
				if (Long.parseLong(id) == userId) {
					return true;
				}
			}
		}
		return false;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCheckVersionList() {
		return checkVersionList;
	}

	public void setCheckVersionList(String checkVersionList) {
		this.checkVersionList = checkVersionList;
	}

	public boolean isCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(boolean checkFlag) {
		this.checkFlag = checkFlag;
	}

	public boolean isRechargeComfirmSwitch() {
		return rechargeComfirmSwitch;
	}

	public void setRechargeComfirmSwitch(boolean rechargeComfirmSwitch) {
		this.rechargeComfirmSwitch = rechargeComfirmSwitch;
	}

	public int getNewBeeCash() {
		return newBeeCash;
	}

	public void setNewBeeCash(int newBeeCash) {
		this.newBeeCash = newBeeCash;
	}

	public int getDefaultCity() {
		return defaultCity;
	}

	public void setDefaultCity(int defaultCity) {
		this.defaultCity = defaultCity;
	}

	public int getPlayLostCashLimit() {
		return playLostCashLimit;
	}

	public void setPlayLostCashLimit(int playLostCashLimit) {
		this.playLostCashLimit = playLostCashLimit;
	}

	public int getPlayWinCashLimit() {
		return playWinCashLimit;
	}

	public void setPlayWinCashLimit(int playWinCashLimit) {
		this.playWinCashLimit = playWinCashLimit;
	}

	public int getRoomLostCashLimit() {
		return roomLostCashLimit;
	}

	public void setRoomLostCashLimit(int roomLostCashLimit) {
		this.roomLostCashLimit = roomLostCashLimit;
	}

	public int getRoomWinCashLimit() {
		return roomWinCashLimit;
	}

	public void setRoomWinCashLimit(int roomWinCashLimit) {
		this.roomWinCashLimit = roomWinCashLimit;
	}

	public int getDayLostCashLimit() {
		return dayLostCashLimit;
	}

	public void setDayLostCashLimit(int dayLostCashLimit) {
		this.dayLostCashLimit = dayLostCashLimit;
	}

	public int getDayWinCashLimit() {
		return dayWinCashLimit;
	}

	public void setDayWinCashLimit(int dayWinCashLimit) {
		this.dayWinCashLimit = dayWinCashLimit;
	}

	public boolean isCashLimitOpen() {
		return cashLimitOpen;
	}

	public void setCashLimitOpen(boolean cashLimitOpen) {
		this.cashLimitOpen = cashLimitOpen;
	}
	
	public boolean getCashLimitOpen() {
		return cashLimitOpen;
	}

	public int getSmsTimeout() {
		return smsTimeout;
	}

	public void setSmsTimeout(int smsTimeout) {
		this.smsTimeout = smsTimeout;
	}

	public boolean isTestBilling() {
		return testBilling;
	}

	public void setTestBilling(boolean testBilling) {
		this.testBilling = testBilling;
	}

	public long getPrivateRoomDiamond() {
		return privateRoomDiamond;
	}

	public void setPrivateRoomDiamond(long privateRoomDiamond) {
		this.privateRoomDiamond = privateRoomDiamond;
	}

	@Override
	public String toString() {
		return "UserConfig [version=" + version + ", checkVersionList=" + checkVersionList + ", checkFlag=" + checkFlag
				+ ", rechargeComfirmSwitch=" + rechargeComfirmSwitch + ", newBeeCash=" + newBeeCash + ", defaultCity="
				+ defaultCity + ", playLostCashLimit=" + playLostCashLimit + ", playWinCashLimit=" + playWinCashLimit
				+ ", roomLostCashLimit=" + roomLostCashLimit + ", roomWinCashLimit=" + roomWinCashLimit
				+ ", dayLostCashLimit=" + dayLostCashLimit + ", dayWinCashLimit=" + dayWinCashLimit + ", cashLimitOpen="
				+ cashLimitOpen + ", smsTimeout=" + smsTimeout + ", testBilling=" + testBilling
				+ ", privateRoomDiamond=" + privateRoomDiamond + "]";
	}


	

}
