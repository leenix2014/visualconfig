package com.dszy.visualconfig.yaml;

import com.esotericsoftware.yamlbeans.YamlReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class SystemConfigLoader {

    final transient static Logger log = LoggerFactory.getLogger(SystemConfigLoader.class);

    public static SystemConfig load(String yamlFilePath, String runEnvironment) {
        return load(yamlFilePath, runEnvironment, null);
    }

    public static SystemConfig load(String yamlFilePath, String runEnvironment, String yamlFilePathRegEx) {
        try {

            if (!StringUtil.isBlank(yamlFilePath) && !StringUtil.isBlank(yamlFilePathRegEx)) {
                String verificationMsg = verification(yamlFilePath, yamlFilePathRegEx);
                if (!StringUtil.isBlank(verificationMsg)) {
                    log.error("配置验证异常 :\r\n" + verificationMsg);
                    return null;
                }
            }

            YamlReader reader = new YamlReader(new FileReader(yamlFilePath));
            Map<String, SystemConfig> systemConfigMap = reader.read(Map.class, SystemConfig.class);
            SystemConfig systemConfig = systemConfigMap.get(runEnvironment);

            if (systemConfig == null) {
                log.error("加载systemConfig对象的yaml格式错误！没有找到 " + runEnvironment + "配置!");
            }
            return systemConfig;
        } catch (Exception e) {
            log.error("加载systemConfig对象的yaml格式错误！", e);
            e.printStackTrace();
        }
        return null;
    }

    public static String verification(String configFilePath, String configRegExFielPath) {

        StringBuilder errSB = new StringBuilder();
        try {
            YamlReader verificationReader;
            // 取正则验证模板数据
            try {
                verificationReader = new YamlReader(new FileReader(configRegExFielPath));
            } catch (Exception e) {
                log.error("读取验证配置文件报错，可能文件不存在!", e);
                return "";
            }

            Object verificationObj = verificationReader.read();
            Map<String, Object> verificationSourceMap = (Map<String, Object>) verificationObj;
            Map<String, String> verificationMap = new HashMap<>();

            if (verificationSourceMap != null && verificationSourceMap.entrySet().iterator().hasNext()) {
                getYamlParamter("", (Map<String, Object>) verificationSourceMap.entrySet().iterator().next().getValue(),
                        verificationMap);
            }

            // 取配置数据
            YamlReader configReader = new YamlReader(new FileReader(configFilePath));
            Object configObj = configReader.read();
            Map<String, Object> configSourceMap = (Map<String, Object>) configObj;
            Map<String, String> configMap = new HashMap<>();

            if (configSourceMap != null && configSourceMap.entrySet().iterator().hasNext()) {
                getYamlParamter("", (Map<String, Object>) configSourceMap.entrySet().iterator().next().getValue(),
                        configMap);
            }

            // 比较
            for (String key : verificationMap.keySet()) {
                String[] values = verificationMap.get(key).split("#123#");
                if (values != null && values.length == 2) {
                    if (key.indexOf("_GROUPVERIFICATION") > -1) {
                        String tempVerKey = key.replace("_GROUPVERIFICATION", "");
                        for (String configKey : configMap.keySet()) {
                            if (configKey.indexOf(tempVerKey) > -1) {

                                matches(values[0], values[1], configKey, configMap.get(configKey), errSB);
                            }
                        }
                    } else {

                        if (!configMap.containsKey(key)) {
                            errSB.append(String.format("\r\n系统配置文件缺少参数:%s   reg:%s", key, values[1]));
                            continue;
                        }
                        matches(values[0], values[1], key, configMap.get(key), errSB);
                    }
                } else {
                    errSB.append("\r\n" + key + "  验证配置对设置格式有误， 格式为： key : <正则表达式>#123#<说明> ");
                }
            }

        } catch (Exception e) {
            log.error("验证配置异常!", e);
            errSB.append("验证配置异常:" + e.getStackTrace().toString());
        }

        return errSB.toString();
    }

    /**
     *
     * @param expression
     *            正则表达式
     * @param explain
     *            正则表达式的说明
     * @param key
     *            yaml键
     * @param value
     *            yaml值
     * @param errSB
     *            错误集合
     */
    private static void matches(String expression, String explain, String key, String value, StringBuilder errSB) {

        Pattern pattern = Pattern.compile(expression);

        if (!pattern.matcher(value).matches()) {
            errSB.append(String.format("\r\n系统配置文件参数格式错误:%s  value:%s   reg:%s", key, value, explain));
        }

    }

    private static void getYamlParamter(String navigation, Map<String, Object> sources, Map<String, String> result) {

        for (String key : sources.keySet()) {

            if (sources.get(key) != null) {
                String value = sources.get(key).toString();

                if (value.indexOf("=") != -1 && value.indexOf("}") != -1    ) {
                    Map<String, Object> childrenMap = (Map<String, Object>) sources.get(key);
                    if (childrenMap != null && childrenMap.size() > 0) {
                        getYamlParamter(navigation + "->" + key, childrenMap, result);
                    }
                }
                else{
                    result.put(navigation + "->" + key, sources.get(key).toString());
                }
            }

        }
    }

}
