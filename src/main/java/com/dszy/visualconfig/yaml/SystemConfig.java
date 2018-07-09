package com.dszy.visualconfig.yaml;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.esotericsoftware.yamlbeans.YamlReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemConfig implements Serializable {

	private static final long serialVersionUID = -7197128849778507659L;

	private int productId;
	private int wxPort;
	private int gamePort;
	private int resPort;
	private int webPort;
	private int grpcPort;
	private int localPort;
	private int extPort;
	private String remoteHost;
	private int remotePort;
	private String agentURL;
	private String agentLoginURL;
	private String shoppingCenterURL;
	private String serverId;
	private String serverURL;
	private String langPath;
	private String pyjRecordPath;
	private boolean singlon;
	private boolean checkAgent;
	private String logLevel;
	private String logFile;
	private int logConsoleDisable;
	private boolean consoleTest;
	private boolean encryptMessage;
	private String zookeeperIp;
	private String activityURL;
	private int activityWebPort;
	private String workerURL;
	private String gameType;
	private int base;
	private boolean simpleProxy;
	private String appid;
	private int userIdLength;
	private String userIdPrefix;
	private String clubAddr;
	//private BullConfig bullConfig;
	private CacheConfig cacheConfig;
	private Map<String, DBConfig> dbConfigMap;
	private GameConfig gameConfig;
	private ResConfig resConfig;
	private CardControlConfig cardControlConfig;
	private Map<String, String> customArg;
	private UserConfig userConfig;
	private Map<String, List<String>> oldClientMap;
	private String apikey;

	private static Thread config;
	private static SystemConfig instance;
	private static String yamlFilePath = "systemConfig.yml";
	private static String yamlFilePathRegEx = "";

	private static String runEnvironment = "development";

	public static final String PRODUCTION = "production";
	public static final String TEST = "test";
	public static final String DEVELOPMENT = "development";

	public Map<String, String> getCustomArg() {
		return customArg;
	}

	public void setCustomArg(Map<String, String> customArg) {
		this.customArg = customArg;
	}

	public Map<String, List<String>> getOldClientMap() {
		return oldClientMap;
	}

	public void setOldClientMap(Map<String, List<String>> oldClientMap) {
		this.oldClientMap = oldClientMap;
	}

	public CardControlConfig getCardControlConfig() {
		return cardControlConfig;
	}

	public void setCardControlConfig(CardControlConfig cardControlConfig) {
		this.cardControlConfig = cardControlConfig;
	}

	public static SystemConfig getInstance() {
		return instance;
	}

	public static String getYamlFilePath() {
		return yamlFilePath;
	}

	public static void setYamlFilePath(String yamlFilePath) {
		SystemConfig.yamlFilePath = yamlFilePath;
	}

	public static String getRunEnvironment() {
		return runEnvironment;
	}

	public static void setRunEnvironment(String runEnvironment) {
		SystemConfig.runEnvironment = runEnvironment;
	}

	public int getExtPort() {
		return extPort;
	}

	public void setExtPort(int extPort) {
		this.extPort = extPort;
	}

	public int getWxPort() {
		return wxPort;
	}

	public void setWxPort(int wxPort) {
		this.wxPort = wxPort;
	}

	public String getAgentURL() {
		return agentURL;
	}

	public void setAgentURL(String agentURL) {
		this.agentURL = agentURL;
	}

	public String getAgentLoginURL() {
		return agentLoginURL;
	}

	public void setAgentLoginURL(String agentLoginURL) {
		this.agentLoginURL = agentLoginURL;
	}

	public String getShoppingCenterURL() {
		return shoppingCenterURL;
	}

	public void setShoppingCenterURL(String shoppingCenterURL) {
		this.shoppingCenterURL = shoppingCenterURL;
	}

	public String getServerURL() {
		return serverURL;
	}

	public void setServerURL(String serverURL) {
		this.serverURL = serverURL;
	}

	public String getLangPath() {
		return langPath;
	}

	public void setLangPath(String langPath) {
		this.langPath = langPath;
	}

	public String getPyjRecordPath() {
		return pyjRecordPath;
	}

	public String getClubAddr() {
		return clubAddr;
	}

	public void setClubAddr(String clubAddr) {
		this.clubAddr = clubAddr;
	}

	public int getGrpcPort() {
		return grpcPort;
	}

	public void setGrpcPort(int grpcPort) {
		this.grpcPort = grpcPort;
	}

	public void setPyjRecordPath(String pyjRecordPath) {
		this.pyjRecordPath = pyjRecordPath;
	}

	public String getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(String logLevel) {
		this.logLevel = logLevel;
	}

	public String getLogFile() {
		return logFile;
	}

	public void setLogFile(String logFile) {
		this.logFile = logFile;
	}

	public int getLogConsoleDisable() {
		return logConsoleDisable;
	}

	public void setLogConsoleDisable(int logConsoleDisable) {
		this.logConsoleDisable = logConsoleDisable;
	}

	public boolean isConsoleTest() {
		return consoleTest;
	}

	public void setConsoleTest(boolean consoleTest) {
		this.consoleTest = consoleTest;
	}

	public String getZookeeperIp() {
		return zookeeperIp;
	}

	public void setZookeeperIp(String zookeeperIp) {
		this.zookeeperIp = zookeeperIp;
	}

	public String getActivityURL() {
		return activityURL;
	}

	public void setActivityURL(String activityURL) {
		this.activityURL = activityURL;
	}

	public String getWorkerURL() {
		return workerURL;
	}

	public void setWorkerURL(String workerURL) {
		this.workerURL = workerURL;
	}

	public int getActivityWebPort() {
		return activityWebPort;
	}

	public void setActivityWebPort(int activityWebPort) {
		this.activityWebPort = activityWebPort;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getGamePort() {
		return gamePort;
	}

	public void setGamePort(int gamePort) {
		this.gamePort = gamePort;
	}

	public int getResPort() {
		return resPort;
	}

	public void setResPort(int resPort) {
		this.resPort = resPort;
	}

	public int getWebPort() {
		return webPort;
	}

	public void setWebPort(int webPort) {
		this.webPort = webPort;
	}

	public int getLocalPort() {
		return localPort;
	}

	public void setLocalPort(int localPort) {
		this.localPort = localPort;
	}

	public String getRemoteHost() {
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	public int getRemotePort() {
		return remotePort;
	}

	public void setRemotePort(int remotePort) {
		this.remotePort = remotePort;
	}

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public boolean isSinglon() {
		return singlon;
	}

	public void setSinglon(boolean singlon) {
		this.singlon = singlon;
	}

	public boolean isCheckAgent() {
		return checkAgent;
	}

	public void setCheckAgent(boolean checkAgent) {
		this.checkAgent = checkAgent;
	}

	public boolean isEncryptMessage() {
		return encryptMessage;
	}

	public void setEncryptMessage(boolean encryptMessage) {
		this.encryptMessage = encryptMessage;
	}

//	public BullConfig getBullConfig() {
//		return bullConfig;
//	}
//
//	public void setBullConfig(BullConfig bullConfig) {
//		this.bullConfig = bullConfig;
//	}

	public CacheConfig getCacheConfig() {
		return cacheConfig;
	}

	public void setCacheConfig(CacheConfig cacheConfig) {
		this.cacheConfig = cacheConfig;
	}

	public Map<String, DBConfig> getDbConfigMap() {
		return dbConfigMap;
	}

	public void setDbConfigMap(Map<String, DBConfig> dbConfigMap) {
		this.dbConfigMap = dbConfigMap;
	}

	public GameConfig getGameConfig() {
		return gameConfig;
	}

	public void setGameConfig(GameConfig gameConfig) {
		this.gameConfig = gameConfig;
	}

	public ResConfig getResConfig() {
		return resConfig;
	}

	public void setResConfig(ResConfig resConfig) {
		this.resConfig = resConfig;
	}

	public UserConfig getUserConfig() {
		return userConfig;
	}

	public void setUserConfig(UserConfig userConfig) {
		this.userConfig = userConfig;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public boolean isSimpleProxy() {
		return simpleProxy;
	}

	public void setSimpleProxy(boolean simpleProxy) {
		this.simpleProxy = simpleProxy;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public int getUserIdLength() {
		return userIdLength;
	}

	public void setUserIdLength(int userIdLength) {
		this.userIdLength = userIdLength;
	}

	public String getUserIdPrefix() {
		return userIdPrefix;
	}

	public void setUserIdPrefix(String userIdPrefix) {
		this.userIdPrefix = userIdPrefix;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	/*****
	 * 取得配置表中的 玩法逻辑处理类名
	 * 
	 * @param appid
	 * @return
	 */
	public List<String> getOldClientMap(String appid) {
		if (SystemConfig.getInstance().getOldClientMap() == null)
			return null;

		return SystemConfig.getInstance().getOldClientMap().get("" + appid);
	}
}
