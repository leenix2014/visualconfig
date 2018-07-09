package com.dszy.visualconfig.yaml;

import java.util.Map;

public class CacheConfig {


	private String url;

	private int port;

	private int database;

	private int database2;
	// 最大连接数
	private int maxTotal=5000;
	// 最大空闲连接数
	private int maxIdle=200;
	// 最小空闲连接数
	private int minIdle=200;
	// 最大获取链接等待时间
	private int maxWaitMillis=2000;
	// 编码格式 1:json;2:protostuff;3:protobuf
    private int codec=1;
	private Map<String, Double> ttl;
	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public int getMaxWaitMillis() {
		return maxWaitMillis;
	}

	public void setMaxWaitMillis(int maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}

	public int getCodec() {
		return codec;
	}

	public void setCodec(int codec) {
		this.codec = codec;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getDatabase() {
		return database;
	}

	public void setDatabase(int database) {
		this.database = database;
	}

	public int getDatabase2() {
		return database2;
	}

	public void setDatabase2(int database2) {
		this.database2 = database2;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Map<String, Double> getTtl() {
		return ttl;
	}

	public void setTtl(Map<String, Double> ttl) {
		this.ttl = ttl;
	}

	private String passwd;

	@Override
	public String toString() {
		return "CacheConfig [url=" + url + ", port=" + port + ", database=" + database + ", database2=" + database2
				+ ", passwd=" + passwd + "]";
	}

}
