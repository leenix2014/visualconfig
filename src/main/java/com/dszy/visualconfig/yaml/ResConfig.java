package com.dszy.visualconfig.yaml;

public class ResConfig {

	private String imageURL = "";
	private String headImgURL = "";
	private String gameZipURL = "";
	private String recordURL = "";
	
	
	private String mergeAndroidURL="";
	private String mergeIOSURL="";
	private String mergeDesc="";
    	
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getHeadImgURL() {
		return headImgURL;
	}
	public void setHeadImgURL(String headImgURL) {
		this.headImgURL = headImgURL;
	}
	public String getGameZipURL() {
		return gameZipURL;
	}
	public void setGameZipURL(String gameZipURL) {
		this.gameZipURL = gameZipURL;
	}
	public String getRecordURL() {
		return recordURL;
	}
	public void setRecordURL(String recordURL) {
		this.recordURL = recordURL;
	}
	
	public String getMergeAndroidURL() {
		return mergeAndroidURL;
	}
	public void setMergeAndroidURL(String mergeAndroidURL) {
		this.mergeAndroidURL = mergeAndroidURL;
	}
	public String getMergeIOSURL() {
		return mergeIOSURL;
	}
	public void setMergeIOSURL(String mergeIOSURL) {
		this.mergeIOSURL = mergeIOSURL;
	}
	public String getMergeDesc() {
		return mergeDesc;
	}
	public void setMergeDesc(String mergeDesc) {
		this.mergeDesc = mergeDesc;
	}
	
	
	@Override
	public String toString() {
		return "ResConfig [imageURL=" + imageURL + ", headImgURL=" + headImgURL + ", gameZipURL=" + gameZipURL
				+ ", recordURL=" + recordURL + ", mergeAndroidURL=" + mergeAndroidURL + ", mergeIOSURL=" + mergeIOSURL
				+ ", mergeDesc=" + mergeDesc + "]";
	}
	


	

}
