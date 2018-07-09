package com.dszy.visualconfig.yaml;

public class CoreConfig {
	
	private static CoreConfig coreConfig;
	public static CoreConfig getCoreConfig() {
		return coreConfig;
	};
	public static void setCoreConfig(CoreConfig config) {
		coreConfig = config;
	};

	private static boolean singlonModel = false;
	private static boolean simpleProxyModel = false;
	private static int productId = 0;
	
	public static int getProductId(){
		return productId;
	}
	
	public static void setProductId(int productId){
		CoreConfig.productId = productId;
	}
	
	public static String getZookeeperUrl(){
		//return PropertyLoader.getValue("zookeeper_ip");
		return SystemConfig.getInstance().getZookeeperIp();
	}
	
	public static String getServerUrl() {
		//return PropertyLoader.getValue("server_url");
		return SystemConfig.getInstance().getServerURL();
	}
	
	public static boolean isClusterModel() {
		return !singlonModel;
	}

	public static void setSinglon(boolean s) {
		singlonModel = s;
	}
	
	
	public static boolean isSimpleProxyModel() {
		return simpleProxyModel;
	}

	public static void setSimpleProxyModel(boolean simpleProxyModel) {
		CoreConfig.simpleProxyModel = simpleProxyModel;
	}

}
