package com.dszy.visualconfig.global;

import com.dszy.visualconfig.yaml.SystemConfig;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Globals {

    public static Map<String, SystemConfig> systemConfigMap = new ConcurrentHashMap<>();
}
