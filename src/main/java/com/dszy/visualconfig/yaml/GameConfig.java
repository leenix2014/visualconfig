package com.dszy.visualconfig.yaml;

import java.util.HashMap;
import java.util.Map;

public class GameConfig {
	
	private boolean testModel = false;

	// 打牌日志是否压缩
	private boolean needZiplog = false;

	// ddz 是否支持明牌
	private boolean ddzSupotPublic = false;

	// ddz 是否支持总是抢地主
	private boolean ddzAwaysGrab = false;

	private boolean mjTestCard = false;

	private int inviteRoomMaxId = 9999;

	private Map<String, String> gameDesktopClassNameMap = new HashMap<String, String>();

	public boolean isTestModel() {
		return testModel;
	}

	public void setTestModel(boolean testModel) {
		this.testModel = testModel;
	}

	public boolean isNeedZiplog() {
		return needZiplog;
	}

	public void setNeedZiplog(boolean needZiplog) {
		this.needZiplog = needZiplog;
	}

	public boolean isDdzSupotPublic() {
		return ddzSupotPublic;
	}

	public void setDdzSupotPublic(boolean ddzSupotPublic) {
		this.ddzSupotPublic = ddzSupotPublic;
	}

	public boolean isDdzAwaysGrab() {
		return ddzAwaysGrab;
	}

	public void setDdzAwaysGrab(boolean ddzAwaysGrab) {
		this.ddzAwaysGrab = ddzAwaysGrab;
	}

	public boolean isMjTestCard() {
		return mjTestCard;
	}

	public void setMjTestCard(boolean mjTestCard) {
		this.mjTestCard = mjTestCard;
	}

	public int getInviteRoomMaxId() {
		return inviteRoomMaxId;
	}

	public void setInviteRoomMaxId(int inviteRoomMaxId) {
		this.inviteRoomMaxId = inviteRoomMaxId;
	}

	public Map<String, String> getGameDesktopClassNameMap() {
		return gameDesktopClassNameMap;
	}

	public void setGameDesktopClassNameMap(Map<String, String> gameDesktopClassNameMap) {
		this.gameDesktopClassNameMap = gameDesktopClassNameMap;
	}

	/*****
	 * 取得配置表中的 玩法逻辑处理类名
	 * 
	 * @param type
	 * @return
	 */
	public String getGameDesktopName(int type) {
		if (gameDesktopClassNameMap == null)
			return null;

		return gameDesktopClassNameMap.get("" + type);
	}

	@Override
	public String toString() {
		return "GameConfig [testModel=" + testModel + ", needZiplog=" + needZiplog + ", ddzSupotPublic="
				+ ddzSupotPublic + ", ddzAwaysGrab=" + ddzAwaysGrab + ", mjTestCard=" + mjTestCard
				+ ", inviteRoomMaxId=" + inviteRoomMaxId + ", gameDesktopClassNameMap=" + gameDesktopClassNameMap + "]";
	}
	
	
}
