package com.dszy.visualconfig.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dszy.visualconfig.consts.ProductMap;
import com.dszy.visualconfig.entity.ActConfigEntity;
import com.dszy.visualconfig.entity.ActGameServersEntity;
import com.dszy.visualconfig.entity.ActMallEntity;
import com.dszy.visualconfig.entity.ActRewardsEntity;
import com.dszy.visualconfig.global.Globals;
import com.dszy.visualconfig.repo.activity.ActConfigRepo;
import com.dszy.visualconfig.repo.activity.ActGameServersRepo;
import com.dszy.visualconfig.repo.activity.ActMallRepo;
import com.dszy.visualconfig.repo.activity.ActRewardsRepo;
import com.dszy.visualconfig.util.HttpUtil;
import com.dszy.visualconfig.yaml.SystemConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActivityController {

    @Autowired
    private Environment env;

    @Autowired
    private ActConfigRepo actConfigRepo;

    @Autowired
    private ActGameServersRepo actGameServersRepo;

    @Autowired
    private ActMallRepo actMallRepo;

    @Autowired
    private ActRewardsRepo actRewardsRepo;

    @GetMapping("/activity")
    public String getConfig(Integer productId){
        ActConfigEntity actConfig = new ActConfigEntity();
        actConfig.setGameId(productId);
        List<ActConfigEntity> actConfigs= actConfigRepo.findAll(Example.of(actConfig));

        List<ActRewardsEntity> actRewards = actRewardsRepo.findAllById(ProductMap.getActRewardIds(productId));

        ExampleMatcher ignoreId = ExampleMatcher.matching().withIgnorePaths("id");
        ActGameServersEntity actGameServer = new ActGameServersEntity();
        actGameServer.setGameId(productId);
        List<ActGameServersEntity> actGameServers = actGameServersRepo.findAll(Example.of(actGameServer, ignoreId));

        ActMallEntity actMall = new ActMallEntity();
        actMall.setGameId(productId);
        List<ActMallEntity> actMalls = actMallRepo.findAll(Example.of(actMall, ignoreId));

        JSONObject result = new JSONObject();
        result.put("actConfigs", JSON.toJSON(actConfigs));
        result.put("actRewards", JSON.toJSON(actRewards));
        result.put("actGameServers", JSON.toJSON(actGameServers));
        result.put("actMalls", JSON.toJSON(actMalls));

        SystemConfig config = Globals.systemConfigMap.get(productId+"");
        if(config != null){
            String res = HttpUtil.get(config.getActivityURL() + env.getProperty("dszy.activityCheckUrl"));
            if(res != null){
                result.put("status", "ok");
            } else {
                result.put("status", "bad");
            }
        } else {
            result.put("status", "No config of productId " + productId);
        }

        return result.toString();
    }
}
