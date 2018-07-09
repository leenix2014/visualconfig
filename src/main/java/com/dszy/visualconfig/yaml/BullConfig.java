package com.dszy.visualconfig.yaml;

import java.util.HashMap;
import java.util.Map;

public class BullConfig {



	// 完成一局获得经验
	private int roundExp = 10;
	// 庄家获胜额外获得经验
	private int dealerExpEx = 10;
	// 闲家获胜额外获得经验
	private int playerExpEx = 5;
	
	//赔率
	private Map<String, Integer> lossPercentMap = new HashMap<String, Integer>();
	
	//是否开启机器人
	private boolean enabledRobot;

	public int getRoundExp() {
		return roundExp;
	}

	public void setRoundExp(int roundExp) {
		this.roundExp = roundExp;
	}

	public int getDealerExpEx() {
		return dealerExpEx;
	}

	public void setDealerExpEx(int dealerExpEx) {
		this.dealerExpEx = dealerExpEx;
	}

	public int getPlayerExpEx() {
		return playerExpEx;
	}

	public void setPlayerExpEx(int playerExpEx) {
		this.playerExpEx = playerExpEx;
	}

	public Map<String, Integer> getLossPercentMap() {
		return lossPercentMap;
	}

	public void setLossPercentMap(Map<String, Integer> lossPercentMap) {
		this.lossPercentMap = lossPercentMap;
	}

	public boolean isEnabledRobot() {
		return enabledRobot;
	}

	public void setEnabledRobot(boolean enabledRobot) {
		this.enabledRobot = enabledRobot;
	}

	


	private static String getPatternEnglishName(Integer key) {
		String patternName = null;
		if (key == 1000) {
			/** noBull */
			patternName = "noBull";
		}else if (key == 1001) {
			/** bull1 */
			patternName = "bull1";
		}else if (key == 1002) {
			/** bull2 */
			patternName = "bull2";
		}else if (key == 1003) {
			/** bull3 */
			patternName = "bull3";
		}else if (key == 1004) {
			/** bull4 */
			patternName = "bull4";
		}else if (key == 1005) {
			/** bull5 */
			patternName = "bull5";
		}else if (key == 1006) {
			/** bull6 */
			patternName = "bull6";
		}else if (key == 1007) {
			/** bull7 */
			patternName = "bull7";
		}else if (key == 1008) {
			/** bull8 */
			patternName = "bull8";
		}else if (key == 1009) {
			/** bull9 */
			patternName = "bull9";
		}else if (key == 1010) {
			/** bullBull */
			patternName = "bullBull";
		}else if (key == 1011) {
			/** bomb */
			patternName = "bomb";
		}else if (key == 1012) {
			/** fiveFlowerBull */
			patternName = "fiveFlowerBull";
		}else if (key == 1013) {
			/** fiveLittleBull */
			patternName = "fiveLittleBull";
		}else {
			patternName = "unknowPattern";
		}
		return patternName;
	}
	
	/*****
	 * 取得配置表中的 赔率
	 * 
	 * @param pattern
	 * @return
	 */
	public  int getLossPercent(int pattern) {
		if (lossPercentMap == null)
			return 0;
		String patternName = getPatternEnglishName(pattern);
		return lossPercentMap.get(patternName);
	}
	
	 @Override
	public String toString() {
		return "BullConfig [roundExp=" + roundExp + ", dealerExpEx=" + dealerExpEx + ", playerExpEx=" + playerExpEx
				+ ", lossPercentMap=" + lossPercentMap + ", enabledRobot=" + enabledRobot + "]";
	}
}
