package com.dszy.visualconfig.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dszy.visualconfig.entity.SAppStoreEntity;
import com.dszy.visualconfig.entity.SPayConfigEntity;
import com.dszy.visualconfig.global.Globals;
import com.dszy.visualconfig.repo.shoppingcenter.SAppStoreRepo;
import com.dszy.visualconfig.repo.shoppingcenter.SPayConfigRepo;
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
public class ShoppingCenterController {

    @Autowired
    private Environment env;

    @Autowired
    private SAppStoreRepo sAppStoreRepo;

    @Autowired
    private SPayConfigRepo sPayConfigRepo;


    @GetMapping("/shoppingcenter")
    public String getConfig(String productId, String shoppingURL){
        ExampleMatcher ignoreInt = ExampleMatcher.matching().withIgnorePaths("id", "storeId", "wxPay", "applePay", "aliPay", "sortId");
        SAppStoreEntity appStore = new SAppStoreEntity();
        appStore.setProductId(productId);
        List<SAppStoreEntity> appStores = sAppStoreRepo.findAll(Example.of(appStore, ignoreInt));

        ExampleMatcher ignoreId = ExampleMatcher.matching().withIgnorePaths("id");
        SPayConfigEntity payConfig = new SPayConfigEntity();
        payConfig.setProductId(productId);
        List<SPayConfigEntity> payConfigs = sPayConfigRepo.findAll(Example.of(payConfig, ignoreId));

        JSONObject result = new JSONObject();
        result.put("appStores", JSON.toJSON(appStores));
        result.put("payConfigs", JSON.toJSON(payConfigs));

        SystemConfig config = Globals.systemConfigMap.get(productId);
        if(config != null){
            String res = HttpUtil.get(config.getShoppingCenterURL() + env.getProperty("dszy.shoppingCenterCheckUrl"));
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
