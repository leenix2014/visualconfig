package com.dszy.visualconfig.yaml;

import java.util.Map;

public class DBConfig {
	private String address; 
	private String port; 
	private String userName; 
	private String passwd;
	private int dbMaxconn; 
	private int dbFallow;
	private String charSet;
	private Map<String ,String > dbNames;
	
	
	
	public Map<String, String> getDbNames() {
		return dbNames;
	}
	public void setDbNames(Map<String, String> dbNames) {
		this.dbNames = dbNames;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getDbMaxconn() {
		return dbMaxconn;
	}
	public void setDbMaxconn(int dbMaxconn) {
		this.dbMaxconn = dbMaxconn;
	}
	public int getDbFallow() {
		return dbFallow;
	}
	public void setDbFallow(int dbFallow) {
		this.dbFallow = dbFallow;
	}
	public String getCharSet() {
		return charSet;
	}
	public void setCharSet(String charSet) {
		this.charSet = charSet;
	}
	
	@Override
	public String toString() {
		return "DBConfig [address=" + address + ", port=" + port + ", userName=" + userName + ", passwd=" + passwd
				+ ", dbMaxconn=" + dbMaxconn + ", dbFallow=" + dbFallow + ", charSet=" + charSet + ", dbNames="
				+ dbNames + "]";
	}

	
}
