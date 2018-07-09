package com.dszy.visualconfig.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dszy.visualconfig.consts.ProductMap;
import com.dszy.visualconfig.dynamic.datasource.DBIdentifier;
import com.dszy.visualconfig.dynamic.entity.*;
import com.dszy.visualconfig.dynamic.mapper.*;
import com.dszy.visualconfig.global.Globals;
import com.dszy.visualconfig.util.RunShellUtil;
import com.dszy.visualconfig.yaml.DBConfig;
import com.dszy.visualconfig.yaml.SystemConfig;
import com.dszy.visualconfig.yaml.SystemConfigLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class MainController {

    private static Logger log = LoggerFactory.getLogger(MainController.class);

    //Map<path, systemConfig>
    private static Map<String, SystemConfig> systemConfigMap = new ConcurrentHashMap<>();

    @Autowired
    private Environment env;

    @GetMapping("/menu")
    public String menu(){
        String rootPath = env.getProperty("dszy.rootPath");
        File root = new File(rootPath);
        JSONObject jsonObject = new JSONObject();
        for(File province : root.listFiles()){
            if(!province.isDirectory()){
                continue;
            }
            JSONArray array = new JSONArray();
            for(File app : province.listFiles()){
                if(!app.isDirectory()){
                    continue;
                }
                array.add(app.getName());
            }
            jsonObject.put(province.getName(), array);
        }
        return jsonObject.toString();
    }

    @GetMapping("/game/{parentDir}/{gameDir}")
    public String gameConfig(@PathVariable String parentDir, @PathVariable String gameDir, String gateway){
        SystemConfig config = getConfig(parentDir, gameDir, gateway, true);
        if(config == null){
            JSONObject result = new JSONObject();
            result.put("errDesc", "找不到systemConfig.yml文件，请确认目录正确!");
            return result.toString();
        }
        return JSON.toJSON(config).toString();
    }

    @Autowired
    private DictActivityMapper dictActivityMapper;

    @Autowired
    private DictConfigMapper dictConfigMapper;

    @Autowired
    private DictPlaceConfigMapper dictPlaceConfigMapper;

    @Autowired
    private DictPlaceConvertMapper dictPlaceConvertMapper;

    @Autowired
    private DictPlaceGameMapper dictPlaceGameMapper;

    @Autowired
    private DictPlaceMapper dictPlaceMapper;

    @Autowired
    private DictPlaceVersionMapper dictPlaceVersionMapper;

    @Autowired
    private DictTaskMapper dictTaskMapper;

    @GetMapping("/game/{parentDir}/{gameDir}/dictdb")
    public String dictDB(@PathVariable String parentDir, @PathVariable String gameDir, String gateway){
        SystemConfig config = getConfig(parentDir, gameDir, gateway);
        if(config == null){
            JSONObject result = new JSONObject();
            result.put("errDesc", "找不到systemConfig.yml文件，请确认目录正确!");
            return result.toString();
        }
        Map<String, DBConfig> map = config.getDbConfigMap();
        DBConfig dictDb = map.get("dictDataBaseConfig");
        String url = env.getProperty("spring.datasource.url");
        url = String.format(url, dictDb.getAddress(), dictDb.getDbNames().get("dictDbName"), dictDb.getUserName(), dictDb.getPasswd());
        DBIdentifier.setUrl(url);
        Integer productId = config.getProductId();
        List<DictActivityEntity> dictActivityEntities = dictActivityMapper.getAll(productId);
        List<DictConfigEntity> dictConfigEntities = dictConfigMapper.getAll(productId);
        List<DictPlaceConfigEntity> dictPlaceConfigEntities = dictPlaceConfigMapper.getAll(productId);
        List<DictPlaceConvertEntity> dictPlaceConvertEntities = dictPlaceConvertMapper.getAll(productId);
        List<DictPlaceGameEntity> dictPlaceGameEntities = dictPlaceGameMapper.getAll(productId);
        List<DictPlaceEntity> dictPlaceEntities = dictPlaceMapper.getAll(productId);
        List<DictPlaceVersionEntity> dictPlaceVersionEntities = dictPlaceVersionMapper.getAll(productId);
        List<DictTaskEntity> dictTaskEntities = dictTaskMapper.getAll(ProductMap.getActivityId(productId));

        JSONObject result = new JSONObject();
        result.put("dictActivities", JSON.toJSON(dictActivityEntities));
        result.put("dictConfigs", JSON.toJSON(dictConfigEntities));
        result.put("dictPlaceConfigs", JSON.toJSON(dictPlaceConfigEntities));
        result.put("dictPlaceConverts", JSON.toJSON(dictPlaceConvertEntities));
        result.put("dictPlaceGames", JSON.toJSON(dictPlaceGameEntities));
        result.put("dictPlaces", JSON.toJSON(dictPlaceEntities));
        result.put("dictPlaceVersions", JSON.toJSON(dictPlaceVersionEntities));
        result.put("dictTasks", JSON.toJSON(dictTaskEntities));
        return result.toString();
    }

    @Autowired
    private SQuestMapper sQuestMapper;

    @GetMapping("/game/{parentDir}/{gameDir}/devdb")
    public String devDB(@PathVariable String parentDir, @PathVariable String gameDir, String gateway){
        SystemConfig config = getConfig(parentDir, gameDir, gateway);
        if(config == null){
            JSONObject result = new JSONObject();
            result.put("errDesc", "找不到systemConfig.yml文件，请确认目录正确!");
            return result.toString();
        }
        Map<String, DBConfig> map = config.getDbConfigMap();
        DBConfig gameDev = map.get("dataBaseConfig");
        String url = env.getProperty("spring.datasource.url");
        url = String.format(url, gameDev.getAddress(), gameDev.getDbNames().get("dbName"), gameDev.getUserName(), gameDev.getPasswd());
        DBIdentifier.setUrl(url);
        List<SQuestEntity> sQuestEntities = sQuestMapper.getAll();
        JSONObject result = new JSONObject();
        result.put("sQuests", JSON.toJSON(sQuestEntities));
        return result.toString();
    }

    private SystemConfig getConfig(String parentDir, String gameDir, String gateway){
        return this.getConfig(parentDir, gameDir, gateway, false);
    }

    private SystemConfig getConfig(String parentDir, String gameDir, String gateway, boolean refresh){
        String configFile = env.getProperty("dszy.sysconfigFile");
        String wholePath = getConfigDir(parentDir, gameDir, gateway) + File.separator + configFile;
        SystemConfig config = systemConfigMap.get(wholePath);
        if(refresh || config == null){
            config = SystemConfigLoader.load(wholePath, SystemConfig.TEST);
            if(config == null){
                log.warn("找不到{}的test配置", wholePath);
                return null;
            }
            systemConfigMap.put(wholePath, config);
            if(!isGateway(gateway)) {
                Globals.systemConfigMap.put(config.getProductId() + "", config);
            }
        }
        return config;
    }

    private boolean isGateway(String gateway){
        return "true".equals(gateway);
    }

    private String getConfigDir(String parentDir, String gameDir, String gateway){
        String rootPath = env.getProperty("dszy.rootPath");
        String configDir = "";
        if(isGateway(gateway)){
            configDir = env.getProperty("dszy.gatewayServerDir");
        } else {
            configDir = env.getProperty("dszy.gameServerDir");
        }
        return rootPath + File.separator + parentDir + File.separator + gameDir + File.separator + configDir;
    }

    @GetMapping("/shell/{parentDir}/{gameDir}/{cmd}")
    public String runShell(@PathVariable String parentDir, @PathVariable String gameDir, @PathVariable String cmd, String gateway){
        //String res = RunShellUtil.runScript("cmd /c run.bat " + cmd, getConfigDir(parentDir, gameDir));
        String res = RunShellUtil.runScript("sudo ./run.sh " + cmd, getConfigDir(parentDir, gameDir, gateway));
        return res;
    }

    @GetMapping("/netstat/{port}")
    public String runNetstat(@PathVariable String port){
        //sh -c 'netstat -anp | grep -E ":$1\b"'
        String res = RunShellUtil.runScript("/usr/bin/sh", "-c", "/usr/bin/sudo /usr/bin/netstat -lnp | /usr/bin/grep -E \":"+port+"\\b\"");
        return res;
    }

    @GetMapping("/redis/{parentDir}/{gameDir}/{cmd}")
    public String runRedis(@PathVariable String parentDir, @PathVariable String gameDir, @PathVariable String cmd){
        String res = "";
        SystemConfig config = getConfig(parentDir, gameDir, "false");
        int port = 6379;
        if(config != null){
            port = config.getCacheConfig().getPort();
        }
        if("start".equals(cmd)){
            res = RunShellUtil.runScript("sudo ./redis-server " + getRedisConfigDir(parentDir, gameDir) + File.separator + "redis_" + port + ".conf", env.getProperty("dszy.redisPath"));
        } else {
            //res = RunShellUtil.runScript("redis-cli -h 127.0.0.1 -p " + 6379 + " " + cmd, env.getProperty("dszy.redisPath"));
            res = RunShellUtil.runScript("sudo ./redis-cli -h 127.0.0.1 -p " + port + " " + cmd, env.getProperty("dszy.redisPath"));
        }
        return res;
    }

    private String getRedisConfigDir(String parentDir, String gameDir){
        String rootPath = env.getProperty("dszy.rootPath");
        String configDir = env.getProperty("dszy.redisConfigDir");
        return rootPath + File.separator + parentDir + File.separator + gameDir + File.separator + configDir;
    }

    @GetMapping("/{parentDir}/{gameDir}/readme")
    public String getReadme(@PathVariable String parentDir, @PathVariable String gameDir){
        String readmePath = env.getProperty("dszy.rootPath") + File.separator + parentDir + File.separator + gameDir + File.separator + env.getProperty("dszy.readmeFile");

        StringBuilder readme = new StringBuilder();
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(readmePath));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine()) != null){ //使用readLine方法，一次读一行
                readme.append(System.lineSeparator() + s);
            }
        } catch(Exception e){
            log.error("读取readme.md出错", e);
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    log.error("关闭readme.md出错", e);
                }
            }
        }
        return readme.toString();
    }
}
