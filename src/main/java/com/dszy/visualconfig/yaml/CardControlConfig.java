package com.dszy.visualconfig.yaml;

import java.util.Map;

public class CardControlConfig {
	
	//类型分数
	private Map<String,Double> types;
	//概率配置
	private Map<String,Double> probability;
    //最多洗牌次数
    private int n= 3;
    
	public Map<String, Double> getTypes() {
		return types;
	}
	public void setTypes(Map<String, Double> types) {
		this.types = types;
	}
	public Map<String, Double> getProbability() {
		return probability;
	}
	public void setProbability(Map<String, Double> probability) {
		this.probability = probability;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	@Override
	public String toString() {
		return "CardControlConfig [types=" + types + ", probability=" + probability + ", n=" + n + "]";
	}
}
